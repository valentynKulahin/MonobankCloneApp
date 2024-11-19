package com.example.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.dashboard.components.DashboardScreen_Balance
import com.example.dashboard.components.DashboardScreen_Card
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
            DashboardScreen_Pager()
        }
    }
}

@Composable
fun DashboardScreen_Pager(modifier: Modifier = Modifier, cardCount: Int = 2) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { cardCount })
    HorizontalPager(
        state = pagerState,
        modifier = modifier.fillMaxSize().padding(top = 20.dp)
    ) {
        DashboardScreen_BalanceOrCard(isBalance = pagerState.currentPage == 0)
    }
}

@Composable
private fun DashboardScreen_BalanceOrCard(modifier: Modifier = Modifier, isBalance: Boolean) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (isBalance) {
            true -> DashboardScreen_Balance()
            false -> DashboardScreen_Card()
        }
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