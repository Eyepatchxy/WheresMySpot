package com.example.wheresmyspot.ui.screens.home


import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wheresmyspot.ui.components.map.ParkingMap
import com.example.wheresmyspot.viewmodel.MapViewModel

@Composable
fun MapScreen(
    navController: NavController,
    mapViewModel: MapViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    var hasLocationPermission =
        ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED ||
        ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

    val locationPermissionLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                hasLocationPermission = true
            } else {
                hasLocationPermission = false
            }
        }

    LaunchedEffect(hasLocationPermission) {
        if (hasLocationPermission) {
            mapViewModel.fetchUserLocation()
        } else {
            locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    val userLocation = mapViewModel.userLocation.value

    ParkingMap(userLocation)

}

@Preview
@Composable
fun MapScreenPreview() {
    val navController = rememberNavController()

    MapScreen(navController)
}