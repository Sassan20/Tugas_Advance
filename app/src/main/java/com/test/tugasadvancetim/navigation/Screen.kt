package com.test.tugasadvancetim.navigation

sealed class Screen (val route: String) {

    data object Profile: Screen("Profile")
    data object Detail: Screen("detail")
}