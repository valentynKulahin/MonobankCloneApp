package com.example.dashboard.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.designsystem.component.MonoQuickButton
import com.example.designsystem.component.MonobankCard

@Composable
internal fun DashboardScreen_Card(modifier: Modifier = Modifier) {
    Column {
        MonobankCard()
        DashboardScreen_Card_QuickButtons()
        DashboardScreen_CardSettings()
    }
}

@Composable
fun DashboardScreen_Card_QuickButtons(modifier: Modifier = Modifier) {
    Row {
        MonoQuickButton()
        MonoQuickButton()
        MonoQuickButton()
    }
}

@Composable
fun DashboardScreen_CardSettings(modifier: Modifier = Modifier) {

}