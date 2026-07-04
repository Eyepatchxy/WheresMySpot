package com.example.wheresmyspot.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wheresmyspot.data.demodata.PROFILE_DATA
import com.example.wheresmyspot.ui.components.ImageOverlay
import com.example.wheresmyspot.ui.components.ProfileCard
import com.google.firebase.annotations.concurrent.Background

@Composable
fun ProfileScreen(
    navController: NavController
) {
    val profile = PROFILE_DATA                  //Loaded using api

    var imageUrls by remember { mutableStateOf<List<String>>(emptyList()) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Background()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            ProfileCard(
                navController = navController,
                profile = profile,
                { imageUrls = (imageUrls + it) }
            )

        }

        if (imageUrls.isNotEmpty()) {
            ImageOverlay(
                imageUrls = imageUrls,
                onDismiss = { imageUrls = emptyList() }
            )
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    val navController = rememberNavController()

    ProfileScreen(navController)
}