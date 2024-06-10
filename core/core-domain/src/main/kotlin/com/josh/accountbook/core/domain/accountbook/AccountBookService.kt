package com.josh.accountbook.core.domain.accountbook

import org.springframework.stereotype.Service

@Service
class AccountBookService(
    private val accountBookWriter: AccountBookWriter
) {
    fun addAccountBook(accountBookRequestList: List<AccountBookServiceRequest>, memberId: Long): String {
        return accountBookWriter.register(accountBookRequestList, memberId)
    }

}