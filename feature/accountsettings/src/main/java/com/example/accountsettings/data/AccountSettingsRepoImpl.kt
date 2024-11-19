package com.example.accountsettings.data

import com.example.models.user.UserSettingsModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class AccountSettingsRepoImpl @Inject constructor(

): AccountSettingsRepo {

    override fun getAccountSettings(): Flow<UserSettingsModel> {
        TODO("Not yet implemented")
    }


}