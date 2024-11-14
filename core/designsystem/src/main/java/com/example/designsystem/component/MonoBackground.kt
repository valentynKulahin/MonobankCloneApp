package com.example.designsystem.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier

@Composable
fun MonoBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {

    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        CompositionLocalProvider{
            content()
        }
    }

}