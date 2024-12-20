package com.example.savings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SavingsScreen(
    savingsVM: SavingsScreenViewModel = hiltViewModel(),
    onShowSnackbar: suspend (String, String?) -> Boolean
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Welcome to Savings")
    }
}