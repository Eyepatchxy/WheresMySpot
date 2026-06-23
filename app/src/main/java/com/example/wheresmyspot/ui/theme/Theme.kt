package com.example.wheresmyspot.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = White80,

    background = White100,
    onBackground = Blue80,

    surface = White80,
    onSurface = Blue80,

    outline = Border,
    surfaceVariant = White100
)

private val DarkColorScheme = darkColorScheme(
    primary = Primary,
    onPrimary = White80,

    background = DarkBackground,
    onBackground = DarkTextPrimary,

    surface = DarkSurface,
    onSurface = DarkTextPrimary,

    outline = DarkBorder,
    surfaceVariant = DarkSurface
)

@Composable
fun WheresMySpotTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme =
        if(darkTheme) DarkColorScheme
        else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
