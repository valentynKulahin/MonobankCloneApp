package com.example.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.designsystem.component.MonoBackground
import com.example.designsystem.theme.gradientDashboardBottom
import com.example.designsystem.theme.gradientDashboardTop

@Composable
internal fun DashboardScreen(
    dashboardVM: DashboardScreenViewModel = hiltViewModel(),
    onShowSnackbar: suspend (String, String?) -> Boolean
) {
    val accountInfoUiState = dashboardVM.accountInfoUiState.collectAsStateWithLifecycle()

    MonoBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = horizontalDashboardGradient())
        ) {
            DashboardScreen_Balance()
        }
    }
}

@Composable
private fun DashboardScreen_Balance(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Welcome to Dashboard")
    }
}

private fun horizontalDashboardGradient(): Brush {
    return Brush.horizontalGradient(
        colors = listOf(
            gradientDashboardTop,
            gradientDashboardBottom
        ),
        startX = 0F,
        endX = 1000F,
        tileMode = TileMode.Clamp
    )
}