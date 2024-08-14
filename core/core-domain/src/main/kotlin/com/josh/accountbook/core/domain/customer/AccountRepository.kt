package com.josh.accountbook.core.domain.customer

interface AccountRepository {
    fun existByAccountNumberMemberId(accountNumber: String, memberId: Long): Boolean
    fun save(accountRequest: AccountServiceRequest): Account
    fun modify(accountId: Long, accountRequest: AccountServiceRequest): String
}