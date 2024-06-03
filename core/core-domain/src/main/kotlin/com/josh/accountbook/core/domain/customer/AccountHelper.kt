package com.josh.accountbook.core.domain.customer

import org.springframework.stereotype.Component

@Component
class AccountHelper(
    val accountRepository: AccountRepository
) {
    fun existByAccountNumberMemberId(accountNumber: String, memberId: Long) {
        if (accountRepository.existByAccountNumberMemberId(accountNumber, memberId)) {
            throw IllegalArgumentException("이미 존재하는 계좌입니다.")
        }
    }
}