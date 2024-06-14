package com.test.tugasadvancetim.view.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.test.tugasadvancetim.view.navigation.Screen

fun NavGraphBuilder.HomeScreenRoute(navController: NavController) {
    composable(route = Screen.Home.route) {
        HomeScreen(navController)
    }
}