package com.example.models.card

import java.util.UUID

data class CardModel(
    val cardId: UUID,
    val accountId: UUID,
    val cardType: CardType,
    val cardStatus: CardStatus,
    val cardPaymentSystem: CardPaymentSystem,
    val cardNumber: String,
    val expirationDate: String,
    val cardHolderName: String,
    val isVirtual: Boolean,
    val cvvType: CVVType,
    val cvv: String,
    val currency: Int,
    val createdAt: Long,
    val updatedAt: Long
)

enum class CardType {
    Debit, Credit, Virtual
}

enum class CardPaymentSystem {
    Visa, Mastercard, AmericanExpress, Discover
}

enum class CardStatus {
    Active, Blocked, Expired
}

enum class CVVType {
    StandardCVV, DynamicCVV, PersonalCVV
}