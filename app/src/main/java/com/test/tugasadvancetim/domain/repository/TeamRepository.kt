package com.test.tugasadvancetim.domain.repository

import com.test.tugasadvancetim.data.local.entity.TeamEntity
import kotlinx.coroutines.flow.Flow

interface TeamRepository {
    suspend fun upsertTeam(teamEntity: TeamEntity)

    suspend fun deleteTeam(id: Int)

    fun getTeamById(id: Int): Flow<TeamEntity?>

    fun getAllTeam(): Flow<List<TeamEntity>>
}