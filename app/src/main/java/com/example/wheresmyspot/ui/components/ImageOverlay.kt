package com.example.wheresmyspot.ui.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ImageOverlay(
    imageUrls: List<String> = emptyList(),
    currentIndex: Int = 0,
    onDismiss: () -> Unit,
    imageDescription: String? = "Display Image",
    modifier: Modifier = Modifier
) {
    BackHandler(
        onBack = { onDismiss() }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent.copy(0.75f))
            .clickable(
                onClick = { onDismiss() }
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = imageUrls[currentIndex],
            contentDescription = imageDescription,
            contentScale = ContentScale.Fit,
            modifier = modifier
                .clickable(
                    onClick = { }
                )
        )
    }
}