package com.test.tugasadvancetim.view.main

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.test.tugasadvancetim.view.navigation.Screen

fun NavGraphBuilder.TeamScreenRoute(navController: NavController) {
    composable(
        route = Screen.Team.route,
        arguments = listOf(
            navArgument("id") { type = NavType.IntType }
        )
    ) {
        val teamId = it.arguments?.getInt("id", 0)
        TeamScreen(id = teamId ?: 0, navController)
    }
}