package com.example.cashback.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.cashback.CashbackScreen
import kotlinx.serialization.Serializable

@Serializable data object CashbackRoute

fun NavController.navigateToCashback(navOptions: NavOptions? = null) =
    navigate(route = CashbackRoute, navOptions = navOptions)

fun NavGraphBuilder.cashbackScreen(
    onShowSnackbar: suspend (String, String?) -> Boolean
) {
    composable<CashbackRoute> {
        CashbackScreen(onShowSnackbar = onShowSnackbar)
    }
}