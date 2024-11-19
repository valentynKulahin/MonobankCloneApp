package com.example.accountinfo.data

import com.example.models.account.AccountModel
import kotlinx.coroutines.flow.Flow

interface AccountInfoRepo {

    fun getAccountInfo(): Flow<AccountModel>

}