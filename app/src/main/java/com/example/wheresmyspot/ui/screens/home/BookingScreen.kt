package com.example.wheresmyspot.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wheresmyspot.data.constants.BookingTab
import com.example.wheresmyspot.ui.components.Background
import com.example.wheresmyspot.ui.components.TabRow

@Composable
fun BookingScreen(
    navController: NavController,

) {
    var subTab by rememberSaveable { mutableStateOf(BookingTab.CURRENT) }


    Box() {
        Background()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            TabRow(
                selectedTab = subTab,
                onTabSelected = { subTab = it }
            )
        }
    }
}

@Preview
@Composable
fun BookingScreenPreview() {
    val navController = rememberNavController()

    BookingScreen(navController)
}