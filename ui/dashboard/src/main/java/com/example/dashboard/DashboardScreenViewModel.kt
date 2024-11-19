package com.example.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.accountinfo.domain.GetAccountInfoUseCase
import com.example.common.Result
import com.example.common.asResult
import com.example.models.account.AccountModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class DashboardScreenViewModel @Inject constructor(
    accountInfoUseCase: GetAccountInfoUseCase
) : ViewModel() {

    val accountInfoUiState: StateFlow<AccountInfoUiState> =
        accountInfoUiState(accountInfoUseCase = accountInfoUseCase)
            .onStart { AccountInfoUiState.Loading }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = AccountInfoUiState.Loading
            )

}

private fun accountInfoUiState(
    accountInfoUseCase: GetAccountInfoUseCase
): Flow<AccountInfoUiState> {
    return accountInfoUseCase()
        .asResult()
        .map { accountInfoResult ->
            when (accountInfoResult) {
                is Result.Loading -> {
                    AccountInfoUiState.Loading
                }

                is Result.Error -> {
                    AccountInfoUiState.Error(exception = accountInfoResult.exception)
                }

                is Result.Success -> {
                    AccountInfoUiState.Success(accountInfo = accountInfoResult.data)
                }
            }
        }
}

sealed interface AccountInfoUiState {
    data class Error(val exception: Throwable) : AccountInfoUiState
    data object Loading : AccountInfoUiState
    data class Success(val accountInfo: AccountModel) : AccountInfoUiState
}