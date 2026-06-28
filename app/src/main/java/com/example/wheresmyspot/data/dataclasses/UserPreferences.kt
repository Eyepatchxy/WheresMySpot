package com.example.wheresmyspot.data.dataclasses

data class UserPreferences(
    val notificationsEnabled: Boolean = true,
    val defaultVehicleId: String? = null
)