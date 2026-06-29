package com.example.wheresmyspot.ui.screens.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wheresmyspot.data.constants.HomeTab
import com.example.wheresmyspot.ui.components.Background
import com.example.wheresmyspot.ui.components.BottomNavBar
import com.example.wheresmyspot.ui.components.PageTitle

@RequiresApi(Build.VERSION_CODES.O)
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

        Column (
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
                HomeTab.BOOKINGS -> BookingScreen(navController)
                HomeTab.VEHICLES -> VehicleScreen(navController)
                HomeTab.PROFILE -> ProfileScreen()
            }
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    val navController = rememberNavController()

    Home(navController)
}