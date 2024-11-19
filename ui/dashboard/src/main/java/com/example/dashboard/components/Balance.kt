package com.example.dashboard.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.designsystem.component.MonoQuickButton
import com.example.designsystem.component.MonobankBalance

@Composable
internal fun DashboardScreen_Balance(modifier: Modifier = Modifier) {
    Column {
        MonobankBalance(modifier = modifier) {

        }
        DashboardScreen_Balance_QuickButtons()
        DashboardScreen_TransactionHistory()
    }
}

@Composable
fun DashboardScreen_Balance_QuickButtons(modifier: Modifier = Modifier) {
    Row {
        MonoQuickButton()
        MonoQuickButton()
        MonoQuickButton()
    }
}

@Composable
fun DashboardScreen_TransactionHistory(modifier: Modifier = Modifier) {

}