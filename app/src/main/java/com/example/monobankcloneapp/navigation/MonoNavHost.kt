package com.example.monobankcloneapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.cashback.navigation.cashbackScreen
import com.example.credits.navigation.creditsScreen
import com.example.dashboard.navigation.DashboardRoute
import com.example.dashboard.navigation.dashboardScreen
import com.example.monobankcloneapp.ui.MonoAppState
import com.example.more.navigation.moreScreen
import com.example.savings.navigation.savingsScreen

@Composable
fun MonoNavHost(
    monoAppState: MonoAppState,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = monoAppState.navController,
        startDestination = DashboardRoute,
        modifier = modifier
    ) {
        dashboardScreen(onShowSnackbar = onShowSnackbar)
        creditsScreen(onShowSnackbar = onShowSnackbar)
        savingsScreen(onShowSnackbar = onShowSnackbar)
        cashbackScreen(onShowSnackbar = onShowSnackbar)
        moreScreen(onShowSnackbar = onShowSnackbar)
    }
}