package com.josh.accountbook.core.domain.accountbook

import java.time.LocalDate

interface AccountBookRepository {
    fun saveAll(accountBookRequestList: List<AccountBookServiceRequest>, memberId: Long): Int
    fun updateAll(accountBookRequestList: List<AccountBookServiceRequest>): Int
    fun searchByPagination(customerName: String, startYm: LocalDate, endYm: LocalDate, offSet: Int, limit: Int): List<AccountBook>
}