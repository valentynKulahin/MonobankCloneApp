package com.example.dashboard.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.dashboard.DashboardScreen
import kotlinx.serialization.Serializable

@Serializable data object DashboardRoute

fun NavController.navigateToDashboard(navOptions: NavOptions? = null) =
    navigate(route = DashboardRoute, navOptions = navOptions)

fun NavGraphBuilder.dashboardScreen(
    onShowSnackbar: suspend (String, String?) -> Boolean
) {
    composable<DashboardRoute> {
        DashboardScreen(onShowSnackbar = onShowSnackbar)
    }
}