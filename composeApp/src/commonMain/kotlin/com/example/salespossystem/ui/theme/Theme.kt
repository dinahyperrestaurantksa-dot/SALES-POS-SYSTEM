package com.example.salespossystem.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    onPrimary = TextOnPrimary,
    primaryContainer = AccentColor.copy(alpha = 0.1f),
    onPrimaryContainer = PrimaryColor,
    
    secondary = SecondaryColor,
    onSecondary = Color.White,
    
    tertiary = SuccessColor,
    onTertiary = Color.White,
    
    error = ErrorColor,
    onError = Color.White,
    
    background = AppBackground,
    onBackground = TextPrimary,
    
    surface = SurfaceColor,
    onSurface = TextPrimary,
    
    outline = BorderColor
)

private val AdminColorScheme = lightColorScheme(
    primary = AdminPrimary,
    onPrimary = Color.White,
    background = AdminBackground,
    surface = Color.White,
    onBackground = TextPrimary,
    onSurface = TextPrimary
)

@Composable
fun SALESPOSSYSTEMTheme(
    isAdmin: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (isAdmin) AdminColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography
    ) {
        androidx.compose.material3.Surface(
            color = colorScheme.background,
            content = content
        )
    }
}
