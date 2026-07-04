package com.example.wheresmyspot.data.demodata

import com.example.wheresmyspot.data.constants.VehicleType
import com.example.wheresmyspot.data.dataclasses.VehicleInfo

val VEHICLE_DATA = listOf<VehicleInfo>(
    VehicleInfo(
        vehicleId = 1L,
        type = VehicleType.CAR,
        registrationNumber = "MH123456",
        brand = "Mercedes",
        model = "XYZ",
        color = "Violet",
        nickname = "The Car"
    ),
    VehicleInfo(
        vehicleId = 2L,
        type = VehicleType.BIKE,
        registrationNumber = "MH 01 XY 9900",
        brand = "Royal Enfield",
        model = "Classic 350",
        color = "Stealth Black"
    ),
)