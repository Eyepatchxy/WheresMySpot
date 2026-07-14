package com.example.wheresmyspot.ui.screens.details

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wheresmyspot.data.demodata.PARKING_LOT_DATA
import com.example.wheresmyspot.data.demodata.PROFILE_DATA
import com.example.wheresmyspot.data.demodata.VEHICLE_DATA
import com.example.wheresmyspot.ui.components.Background
import com.example.wheresmyspot.ui.components.PageTitle
import com.example.wheresmyspot.ui.components.ParkingLotSummaryCard
import com.example.wheresmyspot.ui.components.VehicleSelectionCard
import com.example.wheresmyspot.ui.components.TimeSelectionCard
import com.example.wheresmyspot.ui.components.CostCard
import com.example.wheresmyspot.ui.theme.FullRed
import java.time.LocalDate
import java.time.LocalTime
import kotlin.math.ceil

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BookingDetailScreen(
    navController: NavController,
    lotId: Long?,
) {
    val parkingLot = PARKING_LOT_DATA.firstOrNull { it.lotId == lotId }
    val profile = PROFILE_DATA
    val defaultVehicle = VEHICLE_DATA.firstOrNull { it.vehicleId == profile.defaultVehicleId }

    var selectedVehicle by remember { mutableStateOf(defaultVehicle) }
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    var startTime by remember { mutableStateOf<LocalTime?>(null) }
    var endTime by remember { mutableStateOf<LocalTime?>(null) }

    val totalHours = remember(startTime, endTime) {
        if (startTime != null && endTime != null && endTime!!.isAfter(startTime)) {
            val minutes = java.time.Duration.between(startTime, endTime).toMinutes()
            ceil(minutes / 60.0)
        } else null
    }

    val totalCost = remember(totalHours) {
        if (totalHours != null && parkingLot != null)
            totalHours * parkingLot.hourlyRate
        else null
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Background()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = WindowInsets.safeDrawing.asPaddingValues().calculateTopPadding(),
                    bottom = WindowInsets.safeDrawing.asPaddingValues().calculateBottomPadding(),
                    start = WindowInsets.safeDrawing.asPaddingValues().calculateStartPadding(LayoutDirection.Ltr),
                    end = WindowInsets.safeDrawing.asPaddingValues().calculateEndPadding(LayoutDirection.Ltr)
                )
        ) {
            if (lotId == null) {
                Text(
                    text = "Lot not found",
                    style = MaterialTheme.typography.titleMedium,
                    color = FullRed
                )
            } else {
                PageTitle(
                    title = "Booking Details",
                    backnav = true,
                    notification = true,
                    navController = navController,
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    parkingLot?.let {
                        ParkingLotSummaryCard(it)
                    }

                    VehicleSelectionCard(
                        selectedVehicle = selectedVehicle,
                        allVehicles = VEHICLE_DATA,
                        onVehicleSelected = { selectedVehicle = it }
                    )

                    TimeSelectionCard(
                        selectedDate = selectedDate,
                        startTime = startTime,
                        endTime = endTime,
                        onDateSelected = { selectedDate = it },
                        onStartTimeSelected = { startTime = it },
                        onEndTimeSelected = { endTime = it }
                    )

                    CostCard(
                        parkingLot = parkingLot,
                        totalHours = totalHours,
                        totalCost = totalCost,
                        onConfirm = { /* handle booking confirmation */ },
                        isConfirmEnabled = selectedVehicle != null
                                && startTime != null
                                && endTime != null
                                && totalHours != null
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun BookingDetailsScreenPreview() {
    MaterialTheme {
        BookingDetailScreen(
            navController = rememberNavController(),
            lotId = 1L
        )
    }
}