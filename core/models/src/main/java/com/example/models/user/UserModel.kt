package com.example.models.user

import java.util.UUID

data class UserModel(
    val userId: UUID,
    val accountId: UUID,
    val name: String,
    val email: String,
    val phoneNumber: String,
    val profileImageUrl: String,
    val isVerified: Boolean
)