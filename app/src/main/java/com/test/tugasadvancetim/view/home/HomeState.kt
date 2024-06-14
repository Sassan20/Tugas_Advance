package com.test.tugasadvancetim.view.home

import com.test.tugasadvancetim.data.local.entity.TeamEntity

data class HomeState(
    val team: List<TeamEntity> = emptyList()
)
