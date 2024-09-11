package com.josh.accountbook.core.domain.accountbook

import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class AccountBookService(
    private val accountBookWriter: AccountBookWriter,
    private val accountBookReader: AccountBookReader
) {
    fun addAccountBook(accountBookRequestList: List<AccountBookServiceRequest>, memberId: Long): Int {
        return accountBookWriter.register(accountBookRequestList, memberId)
    }

    fun modifyAccountBook(accountBookRequestList: List<AccountBookServiceRequest>): Int {
        return accountBookWriter.modify(accountBookRequestList)
    }

    fun searchAccountBooks(
        customerName: String?, accountBookId: Long?, startYm: LocalDate, endYm: LocalDate, limit: Long
    ): List<AccountBookResponse> {
        return accountBookReader.searchAccountBook(customerName, accountBookId, startYm, endYm, limit)
    }

}