package com.josh.accountbook.storage.db.core.accountbook

import com.josh.accountbook.core.domain.accountbook.AccountBookServiceRequest
import com.josh.accountbook.storage.db.core.customer.AccountEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.LocalDate

@Entity
class AccountBookEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val customerId: Long,
    val accountId: Long,
    val amount: BigDecimal,
    val commission: Double,
    val paymentAmount: BigDecimal,
    val paymentDate: LocalDate
) {
    companion object {
        fun create(accountBookServiceRequest: AccountBookServiceRequest): AccountBookEntity {
            return AccountBookEntity(
                null, accountBookServiceRequest.customerId, accountBookServiceRequest.accountId,
                accountBookServiceRequest.amount, accountBookServiceRequest.commission,
                accountBookServiceRequest.paymentAmount, accountBookServiceRequest.paymentDate
            )
        }
    }

}