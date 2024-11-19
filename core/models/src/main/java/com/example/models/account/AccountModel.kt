package com.example.models.account

import com.example.models.bank.BankDetailsModel
import java.util.UUID

data class AccountModel(
    val accountId: UUID,
    val userId: UUID,
    val bankDetails: BankDetailsModel,
    val accountType: AccountType,
    val balance: Double,
    val currency: Int,
    val creditLimit: Double,
    val createdAt: Long,
    val updatedAt: Long
)

enum class AccountType {
    Savings,
    Checking,
    Credit
}