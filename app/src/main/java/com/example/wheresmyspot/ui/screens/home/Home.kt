package com.example.wheresmyspot.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.wheresmyspot.Data.constants.HomeTab
import com.example.wheresmyspot.ui.components.Background
import com.example.wheresmyspot.ui.components.BottomNavBar
import com.example.wheresmyspot.ui.components.PageTitle

@Composable
fun Home(
    navController: NavController,
    tab: HomeTab = HomeTab.MAP
) {

    var selectedTab by rememberSaveable {
        mutableStateOf(HomeTab.MAP)
    }

    selectedTab = tab

    Background()

    Scaffold(
        bottomBar = {
            BottomNavBar(
                selectedTab = selectedTab,
                onTabSelected = {
                    selectedTab = it
                }
            )
        }
    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            PageTitle(
                title = when (selectedTab) {
                    HomeTab.MAP -> "Map"
                    HomeTab.BOOKINGS -> "Booking"
                    HomeTab.VEHICLES -> "Vehicle"
                    HomeTab.PROFILE -> "Profile"
                },
                backnav = false,
                notification = true,
                navController = navController
            )

            when (selectedTab) {
                HomeTab.MAP -> MapScreen()
                HomeTab.BOOKINGS -> BookingScreen()
                HomeTab.VEHICLES -> VehicleScreen(navController)
                HomeTab.PROFILE -> ProfileScreen()
            }
        }
    }
}
