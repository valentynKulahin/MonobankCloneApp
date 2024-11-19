package com.example.accountsettings.data

import com.example.models.user.UserSettingsModel
import kotlinx.coroutines.flow.Flow

interface AccountSettingsRepo {

    fun getAccountSettings(): Flow<UserSettingsModel>

}