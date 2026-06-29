package com.example.wheresmyspot.data.Repository

import com.example.wheresmyspot.data.constants.Amenity
import com.example.wheresmyspot.data.constants.VehicleType
import com.example.wheresmyspot.data.dataclasses.ParkingLotDetails

val PARKING_LOT_DATA = listOf(
    ParkingLotDetails(
        lotId = 1,
        ownerId = 201,
        name = "City Center Parking",

        address = "Civil Lines, Nagpur",
        latitude = 21.1458,
        longitude = 79.0882,

        description = "Secure multi-level parking near shopping complex.",

        imageUrls = listOf(
            "https://picsum.photos/600/400?1",
            "https://picsum.photos/600/400?2"
        ),

        vehicleTypes = listOf(
            VehicleType.CAR,
            VehicleType.BIKE
        ),

        totalSpaces = 120,
        availableSpaces = 38,

        openingTime = "06:00",
        closingTime = "23:00",

        hourlyRate = 40.0,

        rating = 4.6f,
        reviewCount = 182,

        amenities = listOf(
            Amenity.CCTV,
            Amenity.SECURITY,
            Amenity.COVERED
        )
    ),

    ParkingLotDetails(
        lotId = 2,
        ownerId = 202,
        name = "Metro Station Parking",

        address = "Sitabuldi Metro Station, Nagpur",
        latitude = 21.1464,
        longitude = 79.0849,

        description = "Convenient parking beside the metro station.",

        imageUrls = listOf(
            "https://picsum.photos/600/400?3"
        ),

        vehicleTypes = listOf(
            VehicleType.BIKE,
            VehicleType.CAR
        ),

        totalSpaces = 80,
        availableSpaces = 11,

        openingTime = "05:30",
        closingTime = "22:30",

        hourlyRate = 25.0,

        rating = 4.3f,
        reviewCount = 97,

        amenities = listOf(
            Amenity.CCTV,
            Amenity.EV_CHARGING
        )
    ),

    ParkingLotDetails(
        lotId = 3,
        ownerId = 201,
        name = "Airport Parking",

        address = "Dr. Babasaheb Ambedkar International Airport, Nagpur",
        latitude = 21.0922,
        longitude = 79.0472,

        description = "Long-term and short-term airport parking.",

        imageUrls = listOf(
            "https://picsum.photos/600/400?4"
        ),

        vehicleTypes = listOf(
            VehicleType.CAR
        ),

        totalSpaces = 300,
        availableSpaces = 142,

        openingTime = "00:00",
        closingTime = "23:59",

        hourlyRate = 60.0,

        rating = 4.8f,
        reviewCount = 541,

        amenities = listOf(
            Amenity.CCTV,
            Amenity.SECURITY,
            Amenity.COVERED,
            Amenity.EV_CHARGING
        )
    )
)