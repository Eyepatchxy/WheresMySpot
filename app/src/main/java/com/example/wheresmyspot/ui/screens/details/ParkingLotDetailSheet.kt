package com.example.wheresmyspot.ui.screens.details

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wheresmyspot.data.dataclasses.ParkingLotDetails
import com.example.wheresmyspot.data.demodata.PARKING_LOT_DATA
import com.example.wheresmyspot.ui.components.ExpandedView
import com.example.wheresmyspot.ui.components.PeekView

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ParkingLotDetailSheet(
    parkingLot: ParkingLotDetails,
    isExpanded: Boolean,
    onBookClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp))
            .background(MaterialTheme.colorScheme.background)
            .fillMaxHeight(if (isExpanded) 0.9f else 0.63f)
    ) {
        ExpandedView(
            parkingLot = parkingLot,
            onBookClick = onBookClick
        )
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun ParkingLotDetailsSheetPreview() {
    val spot = PARKING_LOT_DATA[0]

    ParkingLotDetailSheet(
        spot,
        false,
        {}
    )
}