package com.example.models.user

import java.util.UUID

data class UserSettingsModel(
    val userId: UUID,
    val theme: AppTheme,
    val language: AppLanguage,
    val notificationsEnabled: Boolean,
    val transactionNotificationsEnabled: Boolean,
    val securitySettings: SecuritySettings
)

enum class AppTheme {
    Light, Dark, System
}

enum class AppLanguage {
    English
}

data class SecuritySettings(
    val biometricAuthEnabled: Boolean,
    val twoFactorAuthEnabled: Boolean,
    val autoLockTimeout: Int,
    val useSecureFlag: Boolean
)