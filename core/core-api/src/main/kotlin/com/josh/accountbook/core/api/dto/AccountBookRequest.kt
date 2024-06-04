package com.josh.accountbook.core.api.dto

import com.josh.accountbook.core.domain.accountbook.AccountBookServiceRequest
import java.math.BigDecimal

data class AccountBookRequest(
    val customerId: Long,
    val accountId: Long,
    val amount: BigDecimal,
    val commission: Double,
    val paymentAmount: BigDecimal
) {
    fun toServiceDto(): AccountBookServiceRequest {
        return AccountBookServiceRequest(customerId, accountId, amount, commission, paymentAmount)
    }

}