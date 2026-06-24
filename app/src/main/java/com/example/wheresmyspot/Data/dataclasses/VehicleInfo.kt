package com.example.wheresmyspot.Data.dataclasses

import com.example.wheresmyspot.Data.constants.VehicleType

data class VehicleInfo(
    val type: VehicleType,
    val number: String,
    val brand: String,
    val model: String,
    val color: String
)