package com.test.tugasadvancetim.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.test.tugasadvancetim.view.navigation.TeamNavGraph

@Composable
fun AppTeam(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    TeamNavGraph(navController = navController, modifier = modifier)
}