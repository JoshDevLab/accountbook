package com.josh.accountbook.core.domain.accountbook

import java.math.BigDecimal

data class AccountBookServiceRequest(
    val customerId: Long,
    val accountId: Long,
    val amount: BigDecimal,
    val commission: Double,
    val paymentAmount: BigDecimal
) {
}