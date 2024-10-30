package com.example.homescreen.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.homescreen.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeScreenRoute

fun NavController.navigateToHomeScreen(navOptions: NavOptions) =
    navigate(route = HomeScreenRoute, navOptions)

fun NavGraphBuilder.homeScreen() {
    composable<HomeScreenRoute> {
        HomeScreen()
    }
}