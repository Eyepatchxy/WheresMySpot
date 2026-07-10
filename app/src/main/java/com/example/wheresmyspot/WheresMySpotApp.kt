package com.example.wheresmyspot

import android.Manifest
import android.app.Application
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import dagger.hilt.android.HiltAndroidApp
import org.maplibre.android.MapLibre
import org.maplibre.android.WellKnownTileServer
import org.maplibre.android.geometry.LatLng

@HiltAndroidApp
class WheresMySpotApp : Application() {

    override fun onCreate() {
        super.onCreate()

        MapLibre.getInstance(
            this,
            "",
            WellKnownTileServer.MapLibre
        )
    }
}