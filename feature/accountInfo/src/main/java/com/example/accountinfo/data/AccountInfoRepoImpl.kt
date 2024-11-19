package com.example.accountinfo.data

import com.example.models.account.AccountModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton
import javax.inject.Inject

@Singleton
internal class AccountInfoRepoImpl @Inject constructor(

): AccountInfoRepo {

    override fun getAccountInfo(): Flow<AccountModel> {
        TODO("Not yet implemented")
    }

}