package com.example.wheresmyspot.data.dataclasses.response

import com.example.wheresmyspot.data.dataclasses.ParkingLotDetails
import org.maplibre.android.geometry.LatLng

data class DestinationCoordinatesResponse(
    val destination: LatLng,
    val parkingLots: List<ParkingLotDetails>
)