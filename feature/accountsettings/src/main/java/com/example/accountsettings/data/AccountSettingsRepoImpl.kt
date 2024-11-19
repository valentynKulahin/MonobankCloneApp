package com.example.accountsettings.data

import com.example.models.user.AppLanguage
import com.example.models.user.AppTheme
import com.example.models.user.SecuritySettings
import com.example.models.user.UserSettingsModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class AccountSettingsRepoImpl @Inject constructor(

) : AccountSettingsRepo {

    override fun getAccountSettings(): Flow<UserSettingsModel> {
        return flow<UserSettingsModel> {
            UserSettingsModel(
                userId = UUID.randomUUID(),
                theme = AppTheme.System,
                language = AppLanguage.English,
                notificationsEnabled = true,
                transactionNotificationsEnabled = true,
                securitySettings = SecuritySettings(
                    biometricAuthEnabled = false,
                    twoFactorAuthEnabled = false,
                    autoLockTimeout = 0,
                    useSecureFlag = false
                )
            )
        }
    }


}