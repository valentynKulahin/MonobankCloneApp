package com.example.monobankcloneapp.ui

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.cashback.navigation.CashbackRoute
import com.example.cashback.navigation.navigateToCashback
import com.example.credits.navigation.CreditsRoute
import com.example.credits.navigation.navigateToCredits
import com.example.dashboard.navigation.DashboardRoute
import com.example.dashboard.navigation.navigateToDashboard
import com.example.data.network.NetworkMonitor
import com.example.monobankcloneapp.navigation.TopLevelDestination
import com.example.more.navigation.MoreRoute
import com.example.more.navigation.navigateToMore
import com.example.savings.navigation.SavingsRoute
import com.example.savings.navigation.navigateToSavings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@Composable
fun rememberMonoAppState(
    networkMonitor: NetworkMonitor,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): MonoAppState {

    return remember(
        navController,
        coroutineScope,
        networkMonitor
    ) {
        MonoAppState(
            navController = navController,
            coroutineScope = coroutineScope,
            networkMonitor = networkMonitor
        )
    }

}

@Stable
class MonoAppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
    networkMonitor: NetworkMonitor
) {

    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @SuppressLint("RestrictedApi")
        @Composable get() = TopLevelDestination.entries.firstOrNull { topLevelDestination ->
            currentDestination?.hasRoute(route = topLevelDestination.route) ?: false
        }

    val isOnline = networkMonitor.isOnline.map(Boolean::not).stateIn(
        scope = coroutineScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = true
    )

    val topLevelDestination: List<TopLevelDestination> = TopLevelDestination.entries

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelDestination = navOptions {
            popUpTo(route = navController.graph.findStartDestination().id) {
                saveState = true
            }

            launchSingleTop = true
            restoreState = true
        }

        when (topLevelDestination) {
            DashboardRoute -> navController.navigateToDashboard(topLevelDestination)
            CreditsRoute -> navController.navigateToCredits(topLevelDestination)
            SavingsRoute -> navController.navigateToSavings(topLevelDestination)
            CashbackRoute -> navController.navigateToCashback(topLevelDestination)
            MoreRoute -> navController.navigateToMore(topLevelDestination)
        }

    }

}