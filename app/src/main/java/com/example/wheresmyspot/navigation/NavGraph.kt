package com.example.wheresmyspot.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.wheresmyspot.Data.constants.HomeTab
import com.example.wheresmyspot.ui.screens.home.Home

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Map.route
    ) {
        composable(Screen.Map.route) {
            Home(navController, HomeTab.MAP)
        }

        composable(Screen.Bookings.route) {
            Home(navController, HomeTab.BOOKINGS)
        }

        composable(Screen.Vehicles.route) {
            Home(navController, HomeTab.VEHICLES)
        }

        composable(Screen.Profile.route) {
            Home(navController, HomeTab.PROFILE)
        }
    }
}