package com.test.tugasadvancetim.data.local

import com.test.tugasadvancetim.data.local.entity.TeamEntity
import com.test.tugasadvancetim.data.local.room.TeamDao

class LocalDataSource private constructor(private val teamDao: TeamDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(taskDao: TeamDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(taskDao)
            }
    }

    suspend fun upsertTeam(task: TeamEntity) = teamDao.upsertTask(task)

    suspend fun deleteTeamById(id: Int) = teamDao.deleteTeamById(id)

    fun getTeamById(taskId: Int) = teamDao.getTeamById(taskId)

    fun getAllTeam() = teamDao.getAllTeam()
}