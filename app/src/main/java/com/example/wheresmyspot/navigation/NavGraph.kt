package com.example.wheresmyspot.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.wheresmyspot.ui.screens.home.Home

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Map.route
    ) {
        composable(Screen.Map.route) {
            Home(navController, 0)
        }

        composable(Screen.Bookings.route) {
            Home(navController, 1)
        }

        composable(Screen.Vehicles.route) {
            Home(navController, 2)
        }

        composable(Screen.Profile.route) {
            Home(navController, 3)
        }
    }
}