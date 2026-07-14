package com.example.wheresmyspot.ui.screens.home


import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.exponentialDecay
import androidx.compose.animation.core.spring
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.animateTo
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wheresmyspot.data.constants.LotDetailsSheetState
import com.example.wheresmyspot.data.demodata.PARKING_LOT_DATA
import com.example.wheresmyspot.navigation.Screen
import com.example.wheresmyspot.ui.components.SearchBar
import com.example.wheresmyspot.ui.components.map.ParkingMap
import com.example.wheresmyspot.ui.screens.details.ParkingLotDetailSheet
import com.example.wheresmyspot.viewmodel.MapViewModel
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MapScreen(
    navController: NavController,
    bottomPadding: Dp = 0.dp,
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
    val parkingLots = PARKING_LOT_DATA
    var lotId by remember { mutableStateOf<Long?>(null) }
    var location by remember { mutableStateOf<String?>(null) }
    var isExpanded by remember { mutableStateOf(false) }

    val parkingLot = remember(lotId, parkingLots) {
        parkingLots.firstOrNull { it.lotId == lotId }
    }
    LaunchedEffect(lotId) {
        Log.d("LotId", lotId.toString())
    }

    val density = LocalDensity.current

    val sheetState = remember {
        AnchoredDraggableState(
            initialValue = LotDetailsSheetState.PEEK,
            positionalThreshold = { distance -> distance * 0.5f },
            velocityThreshold = {
                with(density) { 125.dp.toPx() }
            },
            snapAnimationSpec = spring(),
            decayAnimationSpec = exponentialDecay(),
            confirmValueChange = { true }
        )
    }
    val scope = rememberCoroutineScope()

    LaunchedEffect(sheetState.currentValue) {
        isExpanded = sheetState.currentValue == LotDetailsSheetState.EXPANDED
    }

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            SearchBar(
                onSearch = {
                    mapViewModel.fetchDestinationCoordinates(it)
                    location = it
                }
            )

            ParkingMap(
                userLocation,
                parkingLots,
                {
                    lotId = it
                    scope.launch {
                        sheetState.animateTo(LotDetailsSheetState.PEEK)
                    }
                }
            )
        }


        parkingLot?.let {
            ParkingLotDetailSheet(
                parkingLot = parkingLot,
                sheetState,
                isExpanded,
                {
                    lotId = null
                    Log.d("Hide", "OnHideExecuted")
                },
                {
                    navController.navigate(Screen.BookingDetails.createRoute(parkingLot.lotId))
                },
                bottomPadding,
                Modifier.align(Alignment.BottomCenter)
            )
        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun MapScreenPreview() {
    val navController = rememberNavController()

    MapScreen(navController)
}