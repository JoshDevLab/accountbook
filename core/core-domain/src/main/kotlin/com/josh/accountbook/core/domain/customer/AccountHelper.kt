package com.josh.accountbook.core.domain.customer

import org.springframework.stereotype.Component

@Component
class AccountHelper(
    val accountRepository: AccountRepository
) {
    fun existByAccountNumberMemberId(accountNumber: String, memberId: Long): Boolean {
        return accountRepository.existByAccountNumberMemberId(accountNumber, memberId)
    }
}