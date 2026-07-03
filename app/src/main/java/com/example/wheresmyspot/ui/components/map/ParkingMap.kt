package com.example.wheresmyspot.ui.components.map

import android.location.Location
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.example.wheresmyspot.controllers.ParkingMapController
import com.example.wheresmyspot.data.constants.MapStyle
import org.maplibre.android.camera.CameraUpdateFactory
import org.maplibre.android.geometry.LatLng
import org.maplibre.android.maps.MapLibreMap
import org.maplibre.android.maps.MapView

@Composable
fun ParkingMap(
    userLocation: Location?,
) {
    val context = LocalContext.current
    var controller by remember { mutableStateOf<ParkingMapController?>(null) }
    var mapReady by remember { mutableStateOf(false) }

    val latLng = LatLng(
        userLocation?.latitude ?: 18.5204,
        userLocation?.longitude ?: 73.8567
    )

    val mapView = remember {
        MapView(context).apply {
            getMapAsync { map ->
                controller = ParkingMapController(map)
                controller!!.setStyle(MapStyle.STREETS, { mapReady = true })
            }
        }
    }

    LaunchedEffect(userLocation,  mapReady) {
        if (userLocation != null && controller != null && mapReady) {
            controller!!.animateCamera(latLng, 17.0)
        }
        println("Map ready = $mapReady")
        println("Location = $userLocation")
        println("Animating camera...")
    }

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { mapView }
    )
}