package com.josh.accountbook.storage.db.core.accountbook

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.math.BigDecimal
import java.time.LocalDate

interface AccountBookJpaRepository: JpaRepository<AccountBookEntity, Long> {
    @Modifying
    @Query("update AccountBook ab set ab.amount = :amount and ab.commission = :commission" +
            " and ab.paymentAmount = : paymentAmount and ab.paymentDate = :paymentDate where ab.id = :id")
    fun update(
        @Param(value = "id") id: Long,
        @Param(value = "amount") amount: BigDecimal,
        @Param(value = "commission") commission: Double,
        @Param(value = "paymentAmount") paymentAmount: BigDecimal,
        @Param(value = "paymentDate")  paymentDate: LocalDate
    )
}