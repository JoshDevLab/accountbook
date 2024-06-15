package com.josh.accountbook.storage.db.core.customer

import com.josh.accountbook.core.domain.customer.Account
import com.josh.accountbook.core.domain.customer.AccountRepository
import com.josh.accountbook.core.domain.customer.AccountServiceRequest
import com.josh.accountbook.storage.db.core.customer.QAccountEntity.accountEntity
import com.josh.accountbook.storage.db.core.customer.QCustomerEntity.customerEntity
import com.josh.accountbook.storage.db.core.member.QMemberEntity.memberEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class AccountCoreRepository(
    private val accountJpaRepository: AccountJpaRepository,
    val queryFactory: JPAQueryFactory
):AccountRepository {
    override fun existByAccountNumberMemberId(accountNumber: String, memberId: Long): Boolean {
        val fetchFirst = queryFactory
            .selectOne()
            .from(accountEntity)
            .join(customerEntity).on(accountEntity.customerId.eq(customerEntity.id))
            .join(memberEntity).on(customerEntity.memberId.eq(memberEntity.id))
            .where(memberEntity.id.eq(memberId), accountEntity.accountNumber.eq(accountNumber))
            .fetchFirst()

        return fetchFirst != null
    }

    override fun save(accountRequest: AccountServiceRequest): Account {
        return accountJpaRepository.save(AccountEntity.create(accountRequest)).toDomain()
    }

    override fun modify(accountId: Long, accountRequest: AccountServiceRequest): String {
        return accountJpaRepository.update(accountId, accountRequest.accountNumber, accountRequest.bankName)
    }

}