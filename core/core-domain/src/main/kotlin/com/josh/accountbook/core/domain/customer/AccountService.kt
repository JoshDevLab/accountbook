package com.josh.accountbook.core.domain.customer

import org.springframework.stereotype.Service

@Service
class AccountService(
    private val accountHelper: AccountHelper
) {
    fun register(accountRequest: AccountServiceRequest, memberId: Long): Account {
        accountHelper.existByAccountNumberMemberId(accountRequest.accountNumber, memberId)
        return accountHelper.register(accountRequest)
    }


}