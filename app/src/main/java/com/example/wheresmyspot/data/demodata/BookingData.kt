package com.example.wheresmyspot.data.demodata

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.wheresmyspot.data.constants.BookingStatus
import com.example.wheresmyspot.data.dataclasses.BookingDetails
import com.google.firebase.Timestamp
import java.time.LocalDateTime
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
val BOOKING_DATA = listOf(
    BookingDetails(
        bookingId = 10001,
        lotId = 1,
        userId = 1001,
        vehicleId = 501,

        amountPaid = 120,
        status = BookingStatus.ACTIVE,

        startTime = LocalDateTime.of(
            2026,
            6,
            30,
            0,
            30
        ), // 2026-06-29 09:30
        endTime = LocalDateTime.of(
            2026,
            6,
            30,
            2,
            30
        ),   // 2026-06-29 12:30

        bookedAt = Timestamp(Date(1782624600000L))   // 2026-06-28 09:30
    ),

    BookingDetails(
        bookingId = 10002,
        lotId = 2,
        userId = 1001,
        vehicleId = 502,

        amountPaid = 75,
        status = BookingStatus.UPCOMING,

        startTime = LocalDateTime.of(
            2026,
            7,
            30,
            9,
            30
        ), // 2026-06-30 09:30
        endTime = LocalDateTime.of(
            2026,
            7,
            30,
            11,
            30
        ),   // 2026-06-30 11:30

        bookedAt = Timestamp(Date(1782628200000L))   // 2026-06-28 10:30
    ),

    BookingDetails(
        bookingId = 10003,
        lotId = 3,
        userId = 1001,
        vehicleId = 501,

        amountPaid = 240,
        status = BookingStatus.COMPLETED,

        startTime = LocalDateTime.of(
            2026,
            6,
            26,
            11,
            30
        ), // 2026-06-26 11:30
        endTime = LocalDateTime.of(
            2026,
            6,
            26,
            15,
            30
        ),   // 2026-06-26 15:30

        bookedAt = Timestamp(Date(1782361800000L))   // 2026-06-25 10:30
    )
)