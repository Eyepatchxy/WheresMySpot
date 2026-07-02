package com.example.wheresmyspot.data.dataclasses

data class ProfileInfo(
    val uid: String = "",
    val fullName: String = "",
    var email: String = "",
    val phoneNumber: String? = null,
    var defaultVehicleId: Long? = null,
    var profilePictureUrl: String? = null,
    val drivingLicenceUrl: String? = null,
    val createdAt: Long = 0L
)