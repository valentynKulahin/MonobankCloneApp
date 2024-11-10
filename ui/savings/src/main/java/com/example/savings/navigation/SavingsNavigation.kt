package com.example.savings.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.savings.SavingsScreen
import kotlinx.serialization.Serializable

@Serializable data object SavingsRoute

fun NavController.navigateToSavings(navOptions: NavOptions? = null) =
    navigate(route = SavingsRoute, navOptions = navOptions)

fun NavGraphBuilder.savingsScreen(
    onShowSnackbar: suspend (String, String?) -> Boolean
) {
    composable<SavingsRoute> {
        SavingsScreen(onShowSnackbar = onShowSnackbar)
    }
}