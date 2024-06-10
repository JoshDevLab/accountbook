package com.josh.accountbook.core.domain.accountbook

import java.math.BigDecimal
import java.time.LocalDate

data class AccountBookServiceRequest(
    val customerId: Long,
    val accountId: Long,
    val amount: BigDecimal,
    val commission: Double,
    val paymentAmount: BigDecimal,
    val paymentDate: LocalDate
) {
}