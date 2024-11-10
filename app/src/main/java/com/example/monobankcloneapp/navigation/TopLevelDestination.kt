package com.example.monobankcloneapp.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.cashback.navigation.CashbackRoute
import com.example.credits.navigation.CreditsRoute
import com.example.dashboard.navigation.DashboardRoute
import kotlin.reflect.KClass
import com.example.designsystem.R
import com.example.more.navigation.MoreRoute
import com.example.savings.navigation.SavingsRoute

enum class TopLevelDestination(
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    @StringRes val iconTextId: Int,
    @StringRes val titleTextId: Int,
    val route: KClass<*>
) {
    Dashboard(
        selectedIcon = R.drawable.cardbottombar,
        unselectedIcon = R.drawable.cardbottombar,
        iconTextId = R.string.card,
        titleTextId = R.string.card,
        route = DashboardRoute::class
    ),
    Credits(
        selectedIcon = R.drawable.pie,
        unselectedIcon = R.drawable.pie,
        iconTextId = R.string.credits,
        titleTextId = R.string.credits,
        route = CreditsRoute::class
    ),
    Savings(
        selectedIcon = R.drawable.taxes,
        unselectedIcon = R.drawable.taxes,
        iconTextId = R.string.savings,
        titleTextId = R.string.savings,
        route = SavingsRoute::class
    ),
    Cashback(
        selectedIcon = R.drawable.gift,
        unselectedIcon = R.drawable.gift,
        iconTextId = R.string.cashback,
        titleTextId = R.string.cashback,
        route = CashbackRoute::class
    ),
    More(
        selectedIcon = R.drawable.statistic,
        unselectedIcon = R.drawable.statistic,
        iconTextId = R.string.more,
        titleTextId = R.string.more,
        route = MoreRoute::class
    )

}