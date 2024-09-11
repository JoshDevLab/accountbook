package com.josh.accountbook.storage.db.core.accountbook

import com.josh.accountbook.core.domain.accountbook.AccountBookResponse
import com.josh.accountbook.core.domain.accountbook.AccountBookRepository
import com.josh.accountbook.core.domain.accountbook.AccountBookServiceRequest
import com.josh.accountbook.storage.db.core.accountbook.QAccountBookEntity.accountBookEntity
import com.josh.accountbook.storage.db.core.customer.QAccountEntity.accountEntity
import com.josh.accountbook.storage.db.core.customer.QCustomerEntity.customerEntity
import com.querydsl.core.types.Projections
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import java.time.LocalDate


@Repository
class AccountBookCoreRepository(
    private val accountBookJpaRepository: AccountBookJpaRepository,
    private val queryFactory: JPAQueryFactory
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

    override fun searchBySlice(
        customerName: String,
        accountBookId: Long?,
        startYm: LocalDate,
        endYm: LocalDate,
        offSet: Int,
        limit: Int
    ): List<AccountBookResponse> {
        return queryFactory
            .select(
                Projections.fields(AccountBookResponse::class.java,
                    accountBookEntity.id.`as`("id"),
                    customerEntity.name.`as`("customerName"),
                    accountEntity.accountNumber.`as`("accountNumber"),
                    accountEntity.bankName.`as`("bankName"),
                    accountBookEntity.amount.`as`("amount"),
                    accountBookEntity.commission.`as`("commission"),
                    accountBookEntity.paymentAmount.`as`("paymentAmount"),
                    accountBookEntity.paymentDate.`as`("paymentDate")
                )
            )
            .from(accountBookEntity)
            .join(customerEntity).on(accountBookEntity.customerId.eq(customerEntity.id))
            .join(accountEntity).on(accountBookEntity.accountId.eq(accountEntity.id))
            .where(
                ltAccountBookId(accountBookId),
                customerEntity.name.like("%$customerName%")
            )
            .fetch()
    }

    private fun ltAccountBookId(accountBookId: Long?): BooleanExpression? {
        if (accountBookId == null) {
            return null
        }
        return accountBookEntity.id.lt(accountBookId)
    }
}