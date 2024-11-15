package com.example.models.bank

data class BankDetailsModel(
    val accountNumber: String,
    val iban: String,
    val bicSwift: String,
    val bankName: String,
    val bankAddress: String,
    val beneficiaryName: String,
    val beneficiaryAddress: String
)