package com.example.wheresmyspot.data.demodata

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.wheresmyspot.data.constants.Amenity
import com.example.wheresmyspot.data.constants.VehicleType
import com.example.wheresmyspot.data.dataclasses.ParkingLotDetails
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
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
            "https://picsum.photos/600/400?2",
            "https://picsum.photos/600/400?1",
            "https://picsum.photos/600/400?2",
            "https://picsum.photos/600/400?1",
            "https://picsum.photos/600/400?2"
        ),

        vehicleTypes = listOf(
            VehicleType.CAR,
            VehicleType.BIKE
        ),

        totalSpaces = 120,
        availableSpaces = 38,

        isOpen24x7 = false,
        openingTime = LocalTime.of(6, 0),
        closingTime = LocalTime.of(23, 0),

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

        openingTime = LocalTime.of(5, 30),
        closingTime = LocalTime.of(22, 30),

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

        isOpen24x7 = true,
        openingTime = null,
        closingTime = null,

        hourlyRate = 60.0,

        rating = 4.8f,
        reviewCount = 541,

        amenities = listOf(
            Amenity.CCTV,
            Amenity.SECURITY,
            Amenity.COVERED,
            Amenity.EV_CHARGING
        )
    ),

    ParkingLotDetails(
        lotId = 4,
        ownerId = 203,
        name = "Phoenix Mall Parking",

        address = "Viman Nagar, Pune",
        latitude = 18.5679,
        longitude = 73.9143,

        description = "Covered parking at Phoenix Marketcity.",

        imageUrls = listOf("https://picsum.photos/600/400?5"),

        vehicleTypes = listOf(
            VehicleType.CAR,
            VehicleType.BIKE
        ),

        totalSpaces = 250,
        availableSpaces = 81,

        openingTime = LocalTime.of(8, 0),
        closingTime = LocalTime.of(23, 0),

        hourlyRate = 50.0,

        rating = 4.7f,
        reviewCount = 311,

        amenities = listOf(
            Amenity.CCTV,
            Amenity.COVERED,
            Amenity.SECURITY
        )
    ),

    ParkingLotDetails(
        lotId = 5,
        ownerId = 204,
        name = "Shivajinagar Metro Parking",

        address = "Shivajinagar, Pune",
        latitude = 18.5314,
        longitude = 73.8446,

        description = "Affordable metro parking.",

        imageUrls = listOf("https://picsum.photos/600/400?6"),

        vehicleTypes = listOf(
            VehicleType.CAR,
            VehicleType.BIKE
        ),

        totalSpaces = 90,
        availableSpaces = 19,

        openingTime = LocalTime.of(5,0),
        closingTime = LocalTime.of(23, 30),

        hourlyRate = 20.0,

        rating = 4.2f,
        reviewCount = 89,

        amenities = listOf(
            Amenity.CCTV
        )
    ),

    ParkingLotDetails(
        lotId = 6,
        ownerId = 205,
        name = "CSMT Parking",

        address = "Chhatrapati Shivaji Maharaj Terminus, Mumbai",
        latitude = 18.9402,
        longitude = 72.8356,

        description = "Railway station parking.",

        imageUrls = listOf("https://picsum.photos/600/400?7"),

        vehicleTypes = listOf(
            VehicleType.CAR,
            VehicleType.BIKE
        ),

        totalSpaces = 160,
        availableSpaces = 44,

        isOpen24x7 = true,

        hourlyRate = 60.0,

        rating = 4.5f,
        reviewCount = 260,

        amenities = listOf(
            Amenity.CCTV,
            Amenity.SECURITY
        )
    ),

    ParkingLotDetails(
        lotId = 7,
        ownerId = 206,
        name = "Bandra Sea Link Parking",

        address = "Bandra West, Mumbai",
        latitude = 19.0421,
        longitude = 72.8215,

        description = "Parking near Bandra promenade.",

        imageUrls = listOf("https://picsum.photos/600/400?8"),

        vehicleTypes = listOf(
            VehicleType.CAR
        ),

        totalSpaces = 140,
        availableSpaces = 27,

        openingTime = LocalTime.of(6, 0),
        closingTime = LocalTime.of(23, 0),

        hourlyRate = 70.0,

        rating = 4.6f,
        reviewCount = 187,

        amenities = listOf(
            Amenity.CCTV,
            Amenity.COVERED,
            Amenity.SECURITY
        )
    ),

    ParkingLotDetails(
        lotId = 8,
        ownerId = 207,
        name = "Railway Station Parking",

        address = "Amravati Railway Station, Amravati",
        latitude = 20.9256,
        longitude = 77.7796,

        description = "Open parking near railway station.",

        imageUrls = listOf("https://picsum.photos/600/400?9"),

        vehicleTypes = listOf(
            VehicleType.CAR,
            VehicleType.BIKE
        ),

        totalSpaces = 70,
        availableSpaces = 23,

        openingTime = LocalTime.of(5, 30),
        closingTime = LocalTime.of(22, 0),

        hourlyRate = 25.0,

        rating = 4.1f,
        reviewCount = 55,

        amenities = listOf(
            Amenity.CCTV
        )
    ),

    ParkingLotDetails(
        lotId = 9,
        ownerId = 208,
        name = "Rajkamal Square Parking",

        address = "Rajkamal Square, Amravati",
        latitude = 20.9325,
        longitude = 77.7523,

        description = "Central city parking.",

        imageUrls = listOf("https://picsum.photos/600/400?10"),

        vehicleTypes = listOf(
            VehicleType.CAR,
            VehicleType.BIKE
        ),

        totalSpaces = 110,
        availableSpaces = 41,

        openingTime = LocalTime.of(7, 0),
        closingTime = LocalTime.of(22, 0),

        hourlyRate = 30.0,

        rating = 4.4f,
        reviewCount = 118,

        amenities = listOf(
            Amenity.CCTV,
            Amenity.SECURITY
        )
    ),

    ParkingLotDetails(
        lotId = 10,
        ownerId = 209,
        name = "Marine Drive Parking",

        address = "Marine Drive, Mumbai",
        latitude = 18.9431,
        longitude = 72.8235,

        description = "Parking close to Marine Drive.",

        imageUrls = listOf("https://picsum.photos/600/400?11"),

        vehicleTypes = listOf(
            VehicleType.CAR
        ),

        totalSpaces = 130,
        availableSpaces = 18,

        openingTime = LocalTime.of(6,0),
        closingTime = LocalTime.of(23, 59),

        hourlyRate = 80.0,

        rating = 4.8f,
        reviewCount = 432,

        amenities = listOf(
            Amenity.CCTV,
            Amenity.SECURITY,
            Amenity.COVERED
        )
    ),

    ParkingLotDetails(
        lotId = 11,
        ownerId = 210,
        name = "FC Road Parking",

        address = "FC Road, Pune",
        latitude = 18.5196,
        longitude = 73.8410,

        description = "Street-side paid parking.",

        imageUrls = listOf("https://picsum.photos/600/400?12"),

        vehicleTypes = listOf(
            VehicleType.CAR,
            VehicleType.BIKE
        ),

        totalSpaces = 95,
        availableSpaces = 36,

        openingTime = LocalTime.of(8, 0),
        closingTime = LocalTime.of(22, 0),

        hourlyRate = 35.0,

        rating = 4.3f,
        reviewCount = 104,

        amenities = listOf(
            Amenity.CCTV
        )
    )
)