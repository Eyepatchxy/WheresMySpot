package com.example.wheresmyspot.data.dataclasses

import com.example.wheresmyspot.data.constants.BookingStatus
import com.example.wheresmyspot.data.constants.PaymentStatus
import com.google.firebase.Timestamp
import java.time.LocalDateTime

data class BookingDetails(
    val bookingId: Long,
    val lotId: Long,
    val userId: Long,
    val vehicleId: Long,

    val totalCost: Int,
    val bookingStatus: BookingStatus,
    val paymentStatus: PaymentStatus,

    val startTime: LocalDateTime,
    val endTime: LocalDateTime,

    val bookedAt: Timestamp
)