package com.josh.accountbook.core.domain.accountbook

import org.springframework.stereotype.Component

@Component
class AccountBookWriter(
    private val accountBookRepository: AccountBookRepository
) {
    fun register(accountBookRequestList: List<AccountBookServiceRequest>, memberId: Long): Int {
        return accountBookRepository.saveAll(accountBookRequestList, memberId)
    }

    fun modify(accountBookRequestList: List<AccountBookServiceRequest>): Int {
        return accountBookRepository.updateAll(accountBookRequestList)
    }
}