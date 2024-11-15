package com.example.models.transactions.transfer

import com.example.models.bank.BankDetailsModel

data class TransferDetailsModel(
    val recipientBankDetails: BankDetailsModel,
    val amount: Double,
    val currency: Int,
    val description: String
)
