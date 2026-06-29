package com.example.wheresmyspot.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wheresmyspot.data.Repository.BOOKING_DATA
import com.example.wheresmyspot.data.Repository.PARKING_LOT_DATA
import com.example.wheresmyspot.data.Repository.VEHICLE_DATA
import com.example.wheresmyspot.data.constants.BookingStatus
import com.example.wheresmyspot.data.dataclasses.BookingDetails
import com.example.wheresmyspot.ui.theme.AvailableGreen
import com.example.wheresmyspot.ui.theme.FullRed
import com.example.wheresmyspot.ui.theme.InfoBlue
import com.example.wheresmyspot.ui.theme.LimitedYellow

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BookingCard(
    booking: BookingDetails,
    modifier: Modifier = Modifier
) {
    val lot = PARKING_LOT_DATA[0]               //Fetched using LotId
    val vehicle = VEHICLE_DATA[0]               //Fetched using VehicleId

    Card(
        modifier = modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(28.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column( ) {
                    Text(
                        text = lot.name,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = lot.address,
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                IconButton(
                    modifier = Modifier.size(36.dp),
                    onClick = { /* TODO */ }
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "More Options"
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Between : ${booking.startTime.toLocalTime()} to ${booking.endTime.toLocalTime()}",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = vehicle.nickname ?: vehicle.registrationNumber
                )

                Text(
                    text = "₹${booking.amountPaid}"
                )

                Text(
                    text = booking.status.toString(),
                    fontWeight = FontWeight.Bold,
                    color = when(booking.status) {
                        BookingStatus.CANCELLED -> FullRed
                        BookingStatus.EXPIRED -> LimitedYellow
                        BookingStatus.COMPLETED -> Color.Gray
                        BookingStatus.ACTIVE -> AvailableGreen
                        BookingStatus.UPCOMING -> InfoBlue
                    }
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun BookingCardPreview() {
    BookingCard( BOOKING_DATA[0] )

//    MaterialTheme {
//        Column(
//            modifier = Modifier.padding(16.dp),
//            verticalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            BookingCard( BOOKING_DATA[0] )
//            BookingCard( BOOKING_DATA[1] )
//            BookingCard( BOOKING_DATA[2] )
//        }
//    }
}