package com.example.wheresmyspot.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.wheresmyspot.Data.constants.HomeTab

@Composable
fun BottomNavigation(
    selectedTab: HomeTab,
    onTabSelected: (HomeTab) -> Unit
) {
    val items = listOf(
        HomeTab.MAP to R.drawable.ic_map,
        HomeTab.BOOKINGS to R.drawable.ic_booking,
        HomeTab.VEHICLES to R.drawable.ic_car,
        HomeTab.PROFILE to R.drawable.ic_profile
    )

    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface
    ) {
        items.forEach { (tab, resId) ->
            NavigationBarItem(
                icon = { Icon(painterResource(id = resId), contentDescription = null) },
                label = { Text(tab.name) },
                selected = tab == selectedTab,
                onClick = { onTabSelected(tab) }
            )
        }
    }
}
