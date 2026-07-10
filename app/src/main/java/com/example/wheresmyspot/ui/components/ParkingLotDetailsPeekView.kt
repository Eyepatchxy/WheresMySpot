package com.example.wheresmyspot.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsBike
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.wheresmyspot.R
import com.example.wheresmyspot.data.constants.VehicleType
import com.example.wheresmyspot.data.dataclasses.ParkingLotDetails
import com.example.wheresmyspot.data.demodata.PARKING_LOT_DATA
import com.example.wheresmyspot.ui.theme.AvailableGreen
import com.example.wheresmyspot.ui.theme.FullRed
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PeekView(
    parkingLot: ParkingLotDetails,
    onBookClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val currentTime = LocalTime.now()
    val timeFormatter = DateTimeFormatter.ofPattern("hh:mm a")

    val isParkingLotOpen = parkingLot.isOpen24x7 ||
            (parkingLot.openingTime != null && parkingLot.closingTime != null &&
                    currentTime.isAfter(parkingLot.openingTime) &&
                    currentTime.isBefore(parkingLot.closingTime))

    val availabilityFraction = parkingLot.availableSpaces.toFloat() / parkingLot.totalSpaces
    val availabilityColor = when {
        availabilityFraction > 0.5f -> AvailableGreen
        availabilityFraction > 0.2f -> MaterialTheme.colorScheme.tertiary
        else -> FullRed
    }

    Column() {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_drag),
                contentDescription = "Drag Icon",
                modifier = Modifier.size(16.dp)
            )
        }

        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Image
            if (parkingLot.imageUrls.isNotEmpty()) {
                AsyncImage(
                    model = parkingLot.imageUrls[0],
                    contentDescription = "Parking Lot Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                // Name + Rating
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = parkingLot.name,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = null,
                                modifier = Modifier.size(14.dp),
                                tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.45f)
                            )
                            Text(
                                text = parkingLot.address,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.45f),
                                maxLines = 1
                            )
                        }
                    }
                    RatingDisplay(parkingLot.rating, parkingLot.reviewCount)
                }

                HorizontalDivider(
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                    thickness = 0.5.dp
                )

                // Availability + Open status
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = "${parkingLot.availableSpaces}",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold
                                ),
                                color = availabilityColor
                            )
                            Text(
                                text = "/ ${parkingLot.totalSpaces} spots free",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                            )
                        }
                        LinearProgressIndicator(
                            progress = { availabilityFraction },
                            modifier = Modifier
                                .width(140.dp)
                                .height(4.dp)
                                .clip(RoundedCornerShape(50)),
                            color = availabilityColor,
                            trackColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                    }

                    // Open / Closed status
                    Surface(
                        shape = RoundedCornerShape(50),
                        color = if (isParkingLotOpen)
                            AvailableGreen.copy(alpha = 0.12f)
                        else
                            FullRed.copy(alpha = 0.12f)
                    ) {
                        Column(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(1.dp)
                        ) {
                            Text(
                                text = if (parkingLot.isOpen24x7) "Open 24/7"
                                else if (isParkingLotOpen) "Open"
                                else "Closed",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold
                                ),
                                color = if (isParkingLotOpen) AvailableGreen else FullRed
                            )
                            if (!parkingLot.isOpen24x7) {
                                val time =
                                    if (isParkingLotOpen) parkingLot.closingTime else parkingLot.openingTime
                                Text(
                                    text = "${if (isParkingLotOpen) "Until" else "Opens"} ${
                                        time?.format(
                                            timeFormatter
                                        )
                                    }",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = if (isParkingLotOpen)
                                        AvailableGreen.copy(alpha = 0.7f)
                                    else
                                        FullRed.copy(alpha = 0.7f)
                                )
                            }
                        }
                    }
                }

                // Vehicle types
                if (parkingLot.vehicleTypes.isNotEmpty()) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        parkingLot.vehicleTypes.forEach { type ->
                            val (icon, label) = when (type) {
                                VehicleType.CAR -> Icons.Default.DirectionsCar to "Car"
                                VehicleType.BIKE -> Icons.Default.DirectionsBike to "Bike"
                                VehicleType.TRUCK -> Icons.Default.LocalShipping to "Truck"
                            }
                            VehicleTypeChip(icon = icon, label = label)
                        }
                    }
                }

                HorizontalDivider(
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                    thickness = 0.5.dp
                )

                // Rate + Book button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                        Text(
                            text = "₹${parkingLot.hourlyRate}",
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "per hour",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.45f)
                        )
                    }

                    Button(
                        onClick = onBookClick,
                        enabled = isParkingLotOpen && parkingLot.availableSpaces > 0,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant
                        ),
                        elevation = ButtonDefaults.buttonElevation(4.dp)
                    ) {
                        Text(
                            text = when {
                                !isParkingLotOpen -> "Currently Closed"
                                parkingLot.availableSpaces == 0 -> "Fully Booked"
                                else -> "Book a Spot"
                            },
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun PeekViewPreview() {
    MaterialTheme {
        PeekView(PARKING_LOT_DATA[0])
    }
}