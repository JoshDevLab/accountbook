package com.josh.accountbook.core.domain.accountbook

import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class AccountBookReader(
    private val accountBookRepository: AccountBookRepository
) {
    fun searchAccountBook(
        customerName: String?,
        accountBookId: Long?,
        startYm: LocalDate,
        endYm: LocalDate,
        limit: Long
    ): List<AccountBookResponse> {
        return accountBookRepository.searchBySlice(customerName, accountBookId, startYm, endYm, limit)
    }
}