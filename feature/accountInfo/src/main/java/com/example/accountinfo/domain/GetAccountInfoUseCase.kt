package com.example.accountinfo.domain

import com.example.accountinfo.data.AccountInfoRepo
import com.example.models.account.AccountModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAccountInfoUseCase @Inject constructor(
    private val accountInfoRepo: AccountInfoRepo
) {

    operator fun invoke(): Flow<AccountModel> = accountInfoRepo.getAccountInfo()

}