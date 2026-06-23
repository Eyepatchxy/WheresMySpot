package com.example.wheresmyspot.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Map
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wheresmyspot.Data.constants.HomeTab
import com.example.wheresmyspot.R

@Composable
fun BottomNavBar(
    selectedTab: HomeTab,
    onTabSelected: (HomeTab) -> Unit
) {
    val BAR_HEIGHT = 60.dp
    val ICON_SIZE = 40.dp

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(BAR_HEIGHT),
        shape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp,
            bottomStart = 0.dp,
            bottomEnd = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(BAR_HEIGHT),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            //Map Icon
            Icon(
                painter = painterResource(R.drawable.ic_map),
                contentDescription = "Map",
                modifier = Modifier.size(ICON_SIZE),
                tint = MaterialTheme.colorScheme.onSurface
            )


            //Divider
            Icon(
                painter = painterResource(R.drawable.ic_divider),
                contentDescription = "Divider",
                modifier = Modifier.size(ICON_SIZE),
                tint = MaterialTheme.colorScheme.onSurface
            )


            //Bookings Icon
            Icon(
                painter = painterResource(R.drawable.ic_booking),
                contentDescription = "Bookings",
                modifier = Modifier.size(ICON_SIZE),
                tint = MaterialTheme.colorScheme.onSurface
            )


            //Divider
            Icon(
                painter = painterResource(R.drawable.ic_divider),
                contentDescription = "Divider",
                modifier = Modifier.size(ICON_SIZE),
                tint = MaterialTheme.colorScheme.onSurface
            )


            //Vehicles Icon
            Icon(
                painter = painterResource(R.drawable.ic_car),
                contentDescription = "Vehicles",
                modifier = Modifier.size(ICON_SIZE),
                tint = MaterialTheme.colorScheme.onSurface
            )


            //Divider
            Icon(
                painter = painterResource(R.drawable.ic_divider),
                contentDescription = "Divider",
                modifier = Modifier.size(ICON_SIZE),
                tint = MaterialTheme.colorScheme.onSurface
            )


            //Profile Icon
            Icon(
                painter = painterResource(R.drawable.ic_profile),
                contentDescription = "Profile",
                modifier = Modifier.size(ICON_SIZE),
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Preview
@Composable
fun PreviewBottomNavBar() {
    BottomNavBar(
        selectedTab = HomeTab.MAP,
        onTabSelected = {}
    )
}