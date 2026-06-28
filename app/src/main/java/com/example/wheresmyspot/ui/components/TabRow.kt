package com.example.wheresmyspot.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wheresmyspot.data.constants.BookingTab

@Composable
fun TabRow(
    selectedTab: BookingTab,
    onTabSelected: (BookingTab) -> Unit
) {
    val tabs = listOf(
        BookingTab.RESERVATIONS to "Reservations",
        BookingTab.CURRENT      to "Current",
        BookingTab.HISTORY      to "History"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        tabs.forEach { (tab, label) ->
            Tab(
                modifier = Modifier.weight(1f),
                text = label,
                isSelected = tab == selectedTab,
                onClick = { onTabSelected(tab) }
            )
        }
    }
}

@Composable
fun Tab(
    modifier: Modifier = Modifier,
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    // Scale: selected pops up slightly, unselected shrinks
    val scale by animateFloatAsState(
        targetValue = if (isSelected) 1f else 0.94f,
        animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing),
        label = "tabScale"
    )

    // Elevation feel: selected lifts forward on Z axis
    val translationZ by animateFloatAsState(
        targetValue = if (isSelected) 8f else 0f,
        animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing),
        label = "tabZ"
    )

    // Alpha: unselected tabs fade slightly
    val alpha by animateFloatAsState(
        targetValue = if (isSelected) 1f else 0.6f,
        animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing),
        label = "tabAlpha"
    )

    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .height(36.dp)
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
                this.alpha = alpha
                this.shadowElevation = translationZ
            }
            .clip(RoundedCornerShape(8.dp))
            .background(
                if (isSelected) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.surfaceVariant
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 13.sp,
            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
            color = if (isSelected)
                MaterialTheme.colorScheme.onPrimary
            else
                MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview
@Composable
fun TabRowPreview() {
    var subTab by rememberSaveable { mutableStateOf(BookingTab.CURRENT) }

    TabRow(
        selectedTab = subTab,
        onTabSelected = { subTab = it }
    )
}