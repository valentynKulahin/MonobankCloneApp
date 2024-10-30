package com.example.monobankcloneapp.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import kotlin.reflect.KClass
import com.example.designsystem.R
import com.example.homescreen.navigation.HomeScreenRoute

enum class TopLevelDestination(
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    @StringRes val iconTextId: Int,
    @StringRes val titleTextId: Int,
    val route: KClass<*>
) {
    HomeScreen(
        selectedIcon = R.drawable.cardbottombar,
        unselectedIcon = R.drawable.cardbottombar,
        iconTextId = R.string.card,
        titleTextId = R.string.card,
        route = HomeScreenRoute::class
    )
}