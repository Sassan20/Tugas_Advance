package com.test.tugasadvancetim.view.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Team : Screen("team/{id}") {
        fun createRoute(id: Int?) = "team/$id"
    }
}