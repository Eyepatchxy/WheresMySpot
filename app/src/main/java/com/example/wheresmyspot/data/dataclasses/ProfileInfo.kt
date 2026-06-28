package com.example.wheresmyspot.data.dataclasses

data class ProfileInfo(
    val uid: String = "",
    val fullName: String = "",
    val email: String = "",
    val phoneNumber: String? = null,
    val defaultVehicleId: Long? = null,
    val profilePictureUrl: String? = null,
    val drivingLicenceUrl: String? = null,
    val createdAt: Long = 0L
)