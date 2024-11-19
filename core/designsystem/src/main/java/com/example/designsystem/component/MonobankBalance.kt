package com.example.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MonobankBalance(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth(0.8F)
            .aspectRatio(1.586F),
        contentAlignment = Alignment.CenterStart
    ) {
        content()
    }
}