package com.example.accountinfo.di

import com.example.accountinfo.data.AccountInfoRepo
import com.example.accountinfo.data.AccountInfoRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal class AccountInfoModule {

    @Provides
    fun provideAccountSettingsRepo(): AccountInfoRepo {
        return AccountInfoRepoImpl()
    }


}