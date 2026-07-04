package com.example.wheresmyspot.data.dataclasses

import com.example.wheresmyspot.data.constants.Amenity
import com.example.wheresmyspot.data.constants.VehicleType
import org.maplibre.android.geometry.LatLng

data class ParkingLotDetails(
    val lotId: Long = 0L,
    val ownerId: Long = 0L,
    val name: String = "",

    val address: String = "",
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,

    val description: String = "",
    val imageUrls: List<String> = emptyList(),

    val vehicleTypes: List<VehicleType> = emptyList(),

    val totalSpaces: Int = 0,
    val availableSpaces: Int = 0,

    val openingTime: String = "",
    val closingTime: String = "",

    val hourlyRate: Double = 0.0,

    val rating: Float = 0f,
    val reviewCount: Int = 0,

    val amenities: List<Amenity> = emptyList()
) {
    val latLng: LatLng
        get() = LatLng(latitude, longitude)
}