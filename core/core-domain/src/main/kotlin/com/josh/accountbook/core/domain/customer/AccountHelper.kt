package com.josh.accountbook.core.domain.customer

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AccountHelper(
    private val accountRepository: AccountRepository
) {
    fun existByAccountNumberMemberId(accountNumber: String, memberId: Long) {
        if (accountRepository.existByAccountNumberMemberId(accountNumber, memberId)) {
            throw IllegalArgumentException("이미 존재하는 계좌입니다.")
        }
    }

    @Transactional
    fun register(accountRequest: AccountServiceRequest): Account {
        return accountRepository.save(accountRequest)
    }

    @Transactional
    fun modifyAccount(accountId: Long, accountRequest: AccountServiceRequest): String {
        return accountRepository.modify(accountId, accountRequest)
    }
}