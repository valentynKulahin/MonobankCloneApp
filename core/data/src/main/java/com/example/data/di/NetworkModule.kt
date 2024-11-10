package com.example.data.di

import com.example.data.network.NetworkMonitor
import com.example.data.network.NetworkMonitorRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {

    @Binds
    fun bindsNetworkMonitor(
        networkMonitor: NetworkMonitorRepository,
    ): NetworkMonitor

}