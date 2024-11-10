package com.example.monobankcloneapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.data.network.NetworkMonitor
import com.example.designsystem.theme.MonobankCloneAppTheme
import com.example.monobankcloneapp.ui.MonoApp
import com.example.monobankcloneapp.ui.rememberMonoAppState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.getValue

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    private val mainVM: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)

        var uiState: MainActivityUiState by mutableStateOf(MainActivityUiState.Loading)

        enableEdgeToEdge()
        setContent {

            val monoAppState = rememberMonoAppState(networkMonitor = networkMonitor)

            CompositionLocalProvider {
                MonobankCloneAppTheme {
                    MonoApp(monoAppState = monoAppState)
                }
            }

        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

}