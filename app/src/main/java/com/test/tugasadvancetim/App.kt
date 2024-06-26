package com.test.tugasadvancetim

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.test.tugasadvancetim.view.navigation.Screen

//@Composable
//fun App(
//    modifier: Modifier = Modifier,
//    navController: NavHostController = rememberNavController(),
//) {
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentRoute = navBackStackEntry?.destination?.route
//
//    Scaffold(
//        modifier = modifier
//    ) { contentPadding ->
//        NavHost(
//            navController = navController,
//            startDestination = Screen.Profile.route,
//            modifier = modifier.padding(contentPadding)
//        ) {
//            composable(Screen.Profile.route) {
//               profileScreen(navController = navController)
//            }
//        }
//    }
//}