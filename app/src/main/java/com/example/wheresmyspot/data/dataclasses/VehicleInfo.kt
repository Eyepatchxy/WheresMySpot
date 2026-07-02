package com.example.wheresmyspot.data.dataclasses

import com.example.wheresmyspot.data.constants.VehicleType

data class VehicleInfo(
    val vehicleId: Long = 0L,
    val type: VehicleType = VehicleType.CAR,
    val registrationNumber: String = "",
    val brand: String = "",
    val model: String = "",
    val color: String = "",
    val vehicleImageUrl: String? = null,
    val nickname: String? = null
)