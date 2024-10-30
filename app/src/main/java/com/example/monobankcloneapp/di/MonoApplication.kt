package com.example.monobankcloneapp.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MonoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}