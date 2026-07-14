package com.example.wheresmyspot.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.wheresmyspot.data.constants.HomeTab
import com.example.wheresmyspot.ui.screens.details.BookingDetailScreen
import com.example.wheresmyspot.ui.screens.details.VehicleDetailScreen
import com.example.wheresmyspot.ui.screens.home.Home

@RequiresApi(Build.VERSION_CODES.O)
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

        composable(
            route = Screen.VehicleDetails.route,
            arguments = listOf(
                navArgument("vehicleId") { type = NavType.LongType },
            )
        ) {
            val vehicleId = it.arguments?.getLong("vehicleId")
            VehicleDetailScreen(vehicleId, navController)
        }

        composable(
            route = Screen.BookingDetails.route,
            arguments = listOf(
                navArgument("lotId") { type = NavType.LongType },
            )
        ) {
            val lotId = it.arguments?.getLong("lotId")
            BookingDetailScreen(navController, lotId)
        }
    }
}