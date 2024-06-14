package com.test.tugasadvancetim.view.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.test.tugasadvancetim.view.LoginScreen
import com.test.tugasadvancetim.view.home.HomeScreenRoute
import com.test.tugasadvancetim.view.main.TeamScreenRoute

@Composable
fun TeamNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route,
        modifier = modifier
    ) {
        HomeScreenRoute(navController)
        TeamScreenRoute(navController)
    composable(Screen.Login.route) {
        LoginScreen(navController)
    }

    }
}