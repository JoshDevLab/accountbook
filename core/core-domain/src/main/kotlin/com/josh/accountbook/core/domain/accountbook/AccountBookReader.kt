package com.josh.accountbook.core.domain.accountbook

import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class AccountBookReader(
    private val accountBookRepository: AccountBookRepository
) {
    fun searchAccountBook(
        customerName: String,
        startYm: LocalDate,
        endYm: LocalDate,
        offSet: Int,
        limit: Int
    ): List<AccountBook> {
        return accountBookRepository.searchByPagination(customerName, startYm, endYm, offSet, limit)
    }
}