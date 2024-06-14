package com.test.tugasadvancetim.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.tugasadvancetim.data.local.entity.TeamEntity
import com.test.tugasadvancetim.domain.repository.TeamRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TeamViewModel(
    private val teamRepository: TeamRepository
) : ViewModel() {

    private val _state = MutableStateFlow(TeamState())
    val state = _state.asStateFlow()

    fun onEvent(event: TeamEvent) {
        when (event) {

            is TeamEvent.OnRoleChange -> _state.update {
                it.copy(
                    role = event.role
                )
            }

            is TeamEvent.OnLatitudeChange -> _state.update {
                it.copy(
                    latitude = event.latitude
                )
            }

            is TeamEvent.OnLongitudeChange -> _state.update {
                it.copy(
                    longitude = event.longitude
                )
            }

            is TeamEvent.OnNameChange -> _state.update {
                it.copy(
                    name = event.name
                )
            }
            is TeamEvent.OnGetTeamById -> fetchTeam(event.id)
        }
    }

    fun saveTeam(teamEntity: TeamEntity) = viewModelScope.launch {
        teamRepository.upsertTeam(
            teamEntity = teamEntity
        )
    }

    fun deleteTeam(teamId: Int) = viewModelScope.launch {
        teamRepository.deleteTeam(teamId)
    }

    private fun fetchTeam(teamId: Int) = viewModelScope.launch {
        teamRepository.getTeamById(teamId).collect { team ->
            _state.update {
                it.copy(
                   TeamId = team?.id,
                    name = team?.name ?: "",
                    role = team?.role ?: "",
                    latitude = team?.latitude ?: "",
                    longitude = team?.longitude ?: "",
                )
            }
        }
    }
}