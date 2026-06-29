package com.example.wheresmyspot

import android.app.Application
import org.maplibre.android.MapLibre
import org.maplibre.android.WellKnownTileServer

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