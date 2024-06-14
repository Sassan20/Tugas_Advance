package com.test.tugasadvancetim.view.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.test.tugasadvancetim.view.home.HomeScreenRoute
import com.test.tugasadvancetim.view.main.TeamScreenRoute

@Composable
fun TeamNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        HomeScreenRoute(navController)
        TeamScreenRoute(navController)
    }
}