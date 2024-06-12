package com.josh.accountbook.core.domain.accountbook

interface AccountBookRepository {
    fun saveAll(accountBookRequestList: List<AccountBookServiceRequest>, memberId: Long): Int
}