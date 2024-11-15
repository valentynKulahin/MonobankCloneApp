package com.example.designsystem.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import com.example.designsystem.theme.GradientColors
import com.example.designsystem.theme.LocalGradientColors

@Composable
fun MonoBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {

    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        CompositionLocalProvider {
            content()
        }
    }

}

@Composable
fun MonoGradientBackground(
    modifier: Modifier = Modifier,
    gradientColors: GradientColors = LocalGradientColors.current,
    content: @Composable () -> Unit
) {

    val gradient =
        Brush.horizontalGradient(
            listOf(gradientColors.top, gradientColors.bottom),
            startX = 0F,
            endX = 1F
        )
    Surface(
        modifier = modifier
            .fillMaxSize()
            .drawWithCache { onDrawBehind { drawRect(brush = gradient) } },
    ) {
        CompositionLocalProvider {
            content()
        }
    }

}