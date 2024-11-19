package com.example.monobankcloneapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.accountsettings.domain.GetAccountSettingsUseCase
import com.example.models.user.UserSettingsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getAccountSettingsUseCase: GetAccountSettingsUseCase
) : ViewModel() {

    val uiState: StateFlow<MainActivityUiState> =
        getAccountSettingsUseCase()
            .map { MainActivityUiState.Success(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = MainActivityUiState.Loading
            )

}

sealed interface MainActivityUiState {
    data object Loading : MainActivityUiState
    data class Success(val userSettingsModel: UserSettingsModel) : MainActivityUiState
}