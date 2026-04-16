package com.example.wheresmyspot.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController


@Composable
fun GradientBackground(content: @Composable () -> Unit)
{
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFA49D96),
            Color(0xFF7B9096),
            Color(0xFF3E7381),
            Color(0xFF1E677C),

        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()

    )
    {
        content()
    }
}