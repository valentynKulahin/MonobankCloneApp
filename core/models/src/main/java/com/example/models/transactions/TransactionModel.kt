package com.example.models.transactions

import java.util.UUID

data class TransactionModel(
    val transactionId: UUID,
    val accountId: UUID,
    val transactionType: TransactionType,
    val transactionCategory: TransactionCategory,
    val transactionDate: Long,
    val amount: Double
)

enum class TransactionType {
    Income, Expense, Transfer
}

enum class TransactionCategory {
    Groceries,
    Auto,
    Gasoline,
    Entertainment,
    Restaurants,
    Utilities,
    Health,
    Education,
    Travel,
    Charity,
    Subscriptions,
    Other
}