package com.test.tugasadvancetim.view.main

sealed interface TeamEvent {
    data class OnNameChange(val name: String): TeamEvent
    data class OnRoleChange(val role: String): TeamEvent
    data class OnLatitudeChange(val latitude: String): TeamEvent
    data class OnLongitudeChange(val longitude: String): TeamEvent
    data class OnGetTeamById(val id: Int): TeamEvent
}