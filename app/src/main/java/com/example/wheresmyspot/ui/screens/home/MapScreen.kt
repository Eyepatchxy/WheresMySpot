package com.example.wheresmyspot.ui.screens.home


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import org.maplibre.android.maps.MapView

@Composable
fun MapScreen() {

    val context = LocalContext.current

    val mapView = remember {
        MapView(context).apply {
            getMapAsync { map ->
                map.setStyle(
                    "https://demotiles.maplibre.org/style.json"
                ) {
                    println("Style loaded!")
                }
            }
        }
    }

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { mapView }
    )
}

@Preview
@Composable
fun MapScreenPreview() {
    MapScreen()
}