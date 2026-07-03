package com.example.wheresmyspot.data.constants

import com.example.wheresmyspot.controllers.MAP_TILER_API_KEY

enum class MapStyle(
    val styleUrl: String
) {
    STREETS(
        styleUrl = "https://api.maptiler.com/maps/openstreetmap/style.json?key=${MAP_TILER_API_KEY}"
    ),
    SATELLITE(
        styleUrl = "https://api.maptiler.com/maps/satellite-v4/style.json?key=${MAP_TILER_API_KEY}"
    ),
    HYBRID(
        styleUrl = "https://api.maptiler.com/maps/hybrid-v4/style.json?key=${MAP_TILER_API_KEY}"
    ),
}