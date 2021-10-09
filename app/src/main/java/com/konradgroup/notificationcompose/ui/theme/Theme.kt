package com.konradgroup.notificationcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val LightColorPalette = lightColors(
    primary = TEAL_LIGHT,
    secondary = PINK,
    surface = OFF_WHITE,
    onSurface = Color.Black,
    primaryVariant = TEAL_DARK
)

@Composable
fun NotificationTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        LightColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
