package com.josh.accountbook.core.domain.accountbook

import org.springframework.stereotype.Component

@Component
class AccountBookWriter(
    private val accountBookRepository: AccountBookRepository
) {
    fun register(accountBookRequestList: List<AccountBookServiceRequest>, memberId: Long): String {
        return accountBookRepository.saveAll(accountBookRequestList, memberId)
    }
}