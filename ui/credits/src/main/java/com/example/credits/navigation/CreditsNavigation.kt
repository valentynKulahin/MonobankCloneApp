package com.example.credits.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.credits.CreditsScreen
import kotlinx.serialization.Serializable

@Serializable data object CreditsRoute

fun NavController.navigateToCredits(navOptions: NavOptions) =
    navigate(route = CreditsRoute, navOptions)

fun NavGraphBuilder.creditsScreen(
    onShowSnackbar: suspend (String, String?) -> Boolean
) {
    composable<CreditsRoute> {
        CreditsScreen(onShowSnackbar = onShowSnackbar)
    }
}