package com.example.wheresmyspot.navigation

import com.example.wheresmyspot.data.dataclasses.VehicleInfo

sealed class Screen(val route: String) {

    object Map: Screen("map")

    object Bookings: Screen("bookings")

    object Vehicles: Screen("vehicles")

    object Profile: Screen("profile")

    object EditProfile: Screen("editProfile")

    object VehicleDetails: Screen("vehicleDetails/{vehicleId}") {
        fun createRoute(vehicleId: Long): String {
            return "vehicleDetails/$vehicleId"
        }
    }

    object Notification: Screen("notification")

}