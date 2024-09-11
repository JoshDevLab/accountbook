package com.josh.accountbook.core.domain.accountbook

import java.time.LocalDate

interface AccountBookRepository {
    fun saveAll(accountBookRequestList: List<AccountBookServiceRequest>, memberId: Long): Int
    fun updateAll(accountBookRequestList: List<AccountBookServiceRequest>): Int
    fun searchBySlice(customerName: String?, accountBookId: Long?, startYm: LocalDate, endYm: LocalDate,
                      limit: Long): List<AccountBookResponse>
}