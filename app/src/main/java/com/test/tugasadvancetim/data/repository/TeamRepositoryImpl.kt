package com.test.tugasadvancetim.data.repository

import com.test.tugasadvancetim.data.local.LocalDataSource
import com.test.tugasadvancetim.data.local.entity.TeamEntity
import com.test.tugasadvancetim.domain.repository.TeamRepository
import kotlinx.coroutines.flow.Flow

class TeamRepositoryImpl private constructor(
    private val localDataSource: LocalDataSource
): TeamRepository {

    companion object {
        @Volatile
        private var instance: TeamRepositoryImpl? = null

        fun getInstance(
            localData: LocalDataSource,
        ): TeamRepositoryImpl =
            instance ?: synchronized(this) {
                instance ?: TeamRepositoryImpl(localData)
            }
    }

    override suspend fun upsertTeam(teamEntity: TeamEntity) = localDataSource.upsertTeam(teamEntity)

    override suspend fun deleteTeam(id: Int) = localDataSource.deleteTeamById(id)

    override fun getTeamById(id: Int): Flow<TeamEntity?> = localDataSource.getTeamById(id)

    override fun getAllTeam(): Flow<List<TeamEntity>> = localDataSource.getAllTeam()
}