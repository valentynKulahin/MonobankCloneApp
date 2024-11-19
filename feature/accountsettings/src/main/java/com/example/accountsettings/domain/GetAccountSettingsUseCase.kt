package com.example.accountsettings.domain

import com.example.accountsettings.data.AccountSettingsRepo
import com.example.models.user.UserSettingsModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAccountSettingsUseCase @Inject constructor(
    private val accountSettingsRepo: AccountSettingsRepo
) {

    operator fun invoke(): Flow<UserSettingsModel> = accountSettingsRepo.getAccountSettings()

}