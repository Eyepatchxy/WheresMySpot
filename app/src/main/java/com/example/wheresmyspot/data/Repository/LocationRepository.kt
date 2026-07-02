package com.example.wheresmyspot.data.Repository

import android.content.Context
import android.location.Location
import com.google.android.gms.location.LocationServices

class LocationRepository(
    context: Context
) {

    private val fusedLocationClient =
        LocationServices.getFusedLocationProviderClient(context)

    // functions to get location...
    fun getCurrentLocation()  {
    }
}