package com.example.wheresmyspot.navigation

sealed class Screen(val route: String) {

    object Map: Screen("map")

    object Bookings: Screen("bookings")

    object Vehicles: Screen("vehicles")

    object Profile: Screen("profile")

    object Notification: Screen("notification")

}