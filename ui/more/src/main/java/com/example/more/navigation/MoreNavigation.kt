package com.example.more.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.more.MoreScreen
import kotlinx.serialization.Serializable

@Serializable data object MoreRoute

fun NavController.navigateToMore(navOptions: NavOptions? = null) =
    navigate(route = MoreRoute, navOptions = navOptions)

fun NavGraphBuilder.moreScreen(
    onShowSnackbar: suspend (String, String?) -> Boolean
) {
    composable<MoreRoute> {
        MoreScreen(onShowSnackbar = onShowSnackbar)
    }
}