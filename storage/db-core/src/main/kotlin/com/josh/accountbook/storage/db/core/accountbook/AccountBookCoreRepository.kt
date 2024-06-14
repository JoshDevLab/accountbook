package com.josh.accountbook.storage.db.core.accountbook

import com.josh.accountbook.core.domain.accountbook.AccountBook
import com.josh.accountbook.core.domain.accountbook.AccountBookRepository
import com.josh.accountbook.core.domain.accountbook.AccountBookServiceRequest
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class AccountBookCoreRepository(
    private val accountBookJpaRepository: AccountBookJpaRepository
): AccountBookRepository {
    override fun saveAll(accountBookRequestList: List<AccountBookServiceRequest>, memberId: Long): Int {
        val accountBookEntityList = accountBookRequestList.stream().map { param -> AccountBookEntity.create(param) }.toList()
        accountBookJpaRepository.saveAll(accountBookEntityList)
        return accountBookEntityList.size
    }

    override fun updateAll(accountBookRequestList: List<AccountBookServiceRequest>): Int {
        accountBookRequestList.stream()
            .map {
                param ->
                    accountBookJpaRepository.update(
                        param.id!!, param.amount, param.commission, param.paymentAmount, param.paymentDate
                    )
            }
        return accountBookRequestList.size
    }

    override fun searchByPagination(
        customerName: String,
        startYm: LocalDate,
        endYm: LocalDate,
        offSet: Int,
        limit: Int
    ): List<AccountBook> {
        //TODO
        val list: List<AccountBook> = listOf(AccountBook())
        return list
    }
}