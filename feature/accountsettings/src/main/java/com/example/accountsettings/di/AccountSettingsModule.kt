package com.example.accountsettings.di

import com.example.accountsettings.data.AccountSettingsRepo
import com.example.accountsettings.data.AccountSettingsRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal class AccountSettingsModule {

    @Provides
    fun provideAccountSettingsRepo(): AccountSettingsRepo {
        return AccountSettingsRepoImpl()
    }

}