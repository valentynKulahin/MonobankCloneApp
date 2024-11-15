package com.example.models.transactions.deposit

data class DepositDetailsModel(
    val bankDetailsModel: DepositDetailsModel,
    val reference: String
)
