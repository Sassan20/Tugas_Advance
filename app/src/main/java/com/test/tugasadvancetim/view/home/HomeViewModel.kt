package com.test.tugasadvancetim.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.tugasadvancetim.domain.repository.TeamRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(private val teamRepository: TeamRepository): ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {
        getAllTeam()
    }

    private fun getAllTeam() = viewModelScope.launch(Dispatchers.IO) {
        teamRepository.getAllTeam().collect { team ->
            _state.update {
                it.copy(team = team)
            }
        }
    }
}