package com.test.tugasadvancetim.data.local.room

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.test.tugasadvancetim.data.local.entity.TeamEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {

    @Upsert
    suspend fun upsertTask(taskEntity: TeamEntity)

    @Query("DELETE FROM team WHERE id = :id")
    suspend fun deleteTeamById(id: Int)

    @Query("SELECT * FROM team WHERE id = :id")
    fun getTeamById(id: Int): Flow<TeamEntity?>

    @Query("SELECT * FROM team")
    fun getAllTeam(): Flow<List<TeamEntity>>
}