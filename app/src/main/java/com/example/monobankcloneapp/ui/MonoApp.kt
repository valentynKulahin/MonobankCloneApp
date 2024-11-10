package com.example.monobankcloneapp.ui

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarDuration.Indefinite
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult.ActionPerformed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.designsystem.R
import com.example.monobankcloneapp.navigation.MonoNavHost

@Composable
fun MonoApp(
    modifier: Modifier = Modifier,
    monoAppState: MonoAppState
) {

    val snackbarHostState = remember { SnackbarHostState() }

    val isOnline by monoAppState.isOnline.collectAsStateWithLifecycle()

    // If user is not connected to the internet show a snack bar to inform them.
    val notConnectedMessage = stringResource(R.string.not_connected)
    LaunchedEffect(isOnline) {
        if (!isOnline) {
            snackbarHostState.showSnackbar(
                message = notConnectedMessage,
                duration = Indefinite,
            )
        }
    }

    MonoAppScreen(
        modifier = modifier,
        monoAppState = monoAppState,
        snackbarHostState = snackbarHostState
    )

}

@Composable
fun MonoAppScreen(
    modifier: Modifier = Modifier,
    monoAppState: MonoAppState,
    snackbarHostState: SnackbarHostState
) {
    MonoNavHost(
        monoAppState = monoAppState,
        onShowSnackbar = { message, action ->
            snackbarHostState.showSnackbar(
                message = message,
                actionLabel = action,
                duration = SnackbarDuration.Short,
            ) == ActionPerformed
        }
    )
}