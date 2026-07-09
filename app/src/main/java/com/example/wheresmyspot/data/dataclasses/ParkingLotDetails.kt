package com.example.wheresmyspot.data.dataclasses

import com.example.wheresmyspot.data.constants.Amenity
import com.example.wheresmyspot.data.constants.VehicleType
import org.maplibre.android.geometry.LatLng
import java.time.LocalTime

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

    val isOpen24x7: Boolean = false,
    val openingTime: LocalTime? = null,
    val closingTime: LocalTime? = null,

    val hourlyRate: Double = 0.0,

    val rating: Float = 0f,
    val reviewCount: Int = 0,

    val amenities: List<Amenity> = emptyList()
) {
    val latLng: LatLng
        get() = LatLng(latitude, longitude)

    init {

        require(latitude in -90.0..90.0)

        require(longitude in -180.0..180.0)

        require(rating in 0f..5f)

        require(hourlyRate >= 0)

        require(totalSpaces > 0)

        require(availableSpaces in 0..totalSpaces)

        require(if (!isOpen24x7) {openingTime != null && closingTime != null} else {openingTime == null && closingTime == null})

    }
}