package com.example.wheresmyspot.ui.screens.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import com.example.wheresmyspot.ui.components.Background

@Composable
fun ParkingLotDetailScreen(

) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Background()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = WindowInsets.safeDrawing.asPaddingValues().calculateTopPadding(),
                    bottom = WindowInsets.safeDrawing.asPaddingValues().calculateBottomPadding(),
                    start = WindowInsets.safeDrawing.asPaddingValues().calculateStartPadding( LayoutDirection.Ltr ),
                    end = WindowInsets.safeDrawing.asPaddingValues().calculateEndPadding( LayoutDirection.Ltr )
                )
        ) {

        }
    }
}