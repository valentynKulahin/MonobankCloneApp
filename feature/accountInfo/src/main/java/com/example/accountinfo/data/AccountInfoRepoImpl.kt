package com.example.accountinfo.data

import com.example.models.account.AccountModel
import com.example.models.account.AccountType
import com.example.models.bank.BankDetailsModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.UUID
import javax.inject.Singleton
import javax.inject.Inject

@Singleton
internal class AccountInfoRepoImpl @Inject constructor(

) : AccountInfoRepo {

    override fun getAccountInfo(): Flow<AccountModel> {
        return flow<AccountModel> {
            AccountModel(
                accountId = UUID.randomUUID(),
                userId = UUID.randomUUID(),
                balance = 1000.00,
                currency = 958,
                bankDetails = BankDetailsModel(
                    accountNumber = "7438568324658923",
                    iban = "UA56 7564 9275 7281 21",
                    bicSwift = "SwiftUA",
                    bankName = "MonoBank",
                    bankAddress = "Kyiv, Ukraine",
                    beneficiaryName = "Valentyn Kulahin",
                    beneficiaryAddress = "Vancouver, WA"
                ),
                accountType = AccountType.Savings,
                creditLimit = 1000.00,
                createdAt = 1732042348,
                updatedAt = 1732042348
            )
        }
    }

}