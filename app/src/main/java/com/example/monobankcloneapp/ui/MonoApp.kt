package com.example.monobankcloneapp.ui

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarDuration.Indefinite
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult.ActionPerformed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.designsystem.R
import com.example.designsystem.component.MonoBackground
import com.example.designsystem.component.MonoScaffold
import com.example.designsystem.component.bottombar.MonoNavigationBar
import com.example.designsystem.component.bottombar.MonoNavigationBarItem
import com.example.monobankcloneapp.navigation.MonoNavHost

@Composable
fun MonoApp(
    modifier: Modifier = Modifier,
    monoAppState: MonoAppState
) {

    MonoBackground {
        val snackbarHostState = remember { SnackbarHostState() }
        val isOnline by monoAppState.isOnline.collectAsStateWithLifecycle()
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
            modifier = modifier.systemBarsPadding(),
            monoAppState = monoAppState,
            snackbarHostState = snackbarHostState
        )
    }

}

@Composable
fun MonoAppScreen(
    modifier: Modifier = Modifier,
    monoAppState: MonoAppState,
    snackbarHostState: SnackbarHostState
) {

    MonoScaffold(
        modifier = modifier,
        snackbarHostState = { SnackbarHostState() },
        bottomBar = {
            MonoNavigationBar {
                val currentTopLevelDestination = monoAppState.currentTopLevelDestination
                monoAppState.topLevelDestination.forEach { destination ->

                    val selected = currentTopLevelDestination == destination


                    MonoNavigationBarItem(
                        selected = selected,
                        onClick = {
                            monoAppState.navigateToTopLevelDestination(destination)
                        },
                        icon = {
                            if (selected)
                                Icon(
                                    painter = painterResource(id = destination.selectedIcon),
                                    contentDescription = null,
                                    modifier = Modifier.size(35.dp),
                                    tint = Color.Red
                                )
                            else
                                Icon(
                                    painter = painterResource(id = destination.unselectedIcon),
                                    contentDescription = null,
                                    modifier = Modifier.size(35.dp)
                                )
                        },
                        label = {
                            Text(
                                text = stringResource(destination.iconTextId),
                                color = if (selected) Color.Red else Color.Unspecified
                            )
                        },
                        interactionSource = remember { MutableInteractionSource() }
                    )
                }
            }
        }
    ) {
        Column(
            modifier = modifier.fillMaxSize()
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
    }


}