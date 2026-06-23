package com.example.wheresmyspot.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.wheresmyspot.Data.constants.HomeTab
import com.example.wheresmyspot.R

@Composable
fun BottomNavBar(
    selectedTab: HomeTab,
    onTabSelected: (HomeTab) -> Unit
) {
    val items = listOf(
        HomeTab.MAP to R.string.map,
        HomeTab.BOOKINGS to R.string.bookings,
        HomeTab.VEHICLES to R.string.vehicles,
        HomeTab.PROFILE to R.string.profile
    )

    NavigationRail(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface
    ) {
        items.forEach { (tab, resId) ->
            NavigationRailItem(
                icon = { Icon(painterResource(id = R.drawable.ic_map), contentDescription = null) },
                label = { Text(stringResource(resId)) },
                selected = tab == selectedTab,
                onClick = { onTabSelected(tab) }
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
