package com.example.wheresmyspot.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wheresmyspot.data.Repository.PROFILE_DATA
import com.example.wheresmyspot.data.Repository.VEHICLE_DATA
import com.example.wheresmyspot.ui.components.Background
import com.example.wheresmyspot.ui.components.VehicleCard

@Composable
fun VehicleScreen(
    navController: NavController,
) {
    val vehicles = VEHICLE_DATA
    val profile = PROFILE_DATA

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Background()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    vertical = 16.dp,
                    horizontal = 20.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(vehicles.size) { index ->
                val vehicle = vehicles[index]

                VehicleCard(
                    vehicleInfo = vehicle,
                    isDefault = ( vehicle.vehicleId == profile.defaultVehicleId ),
                    navController = navController
                )
            }
        }
    }
}

@Preview
@Composable
fun VehicleScreenPreview() {
    val navController = rememberNavController()

    VehicleScreen(navController)
}