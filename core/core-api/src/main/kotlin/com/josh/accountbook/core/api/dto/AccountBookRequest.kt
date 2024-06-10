package com.josh.accountbook.core.api.dto

import com.josh.accountbook.core.domain.accountbook.AccountBookServiceRequest
import java.math.BigDecimal
import java.time.LocalDate

data class AccountBookRequest(
    val customerId: Long,
    val accountId: Long,
    val amount: BigDecimal,
    val commission: Double,
    val paymentAmount: BigDecimal,
    val paymentDate: LocalDate
) {
    fun toServiceDto(): AccountBookServiceRequest {
        return AccountBookServiceRequest(customerId, accountId, amount, commission, paymentAmount, paymentDate)
    }

}