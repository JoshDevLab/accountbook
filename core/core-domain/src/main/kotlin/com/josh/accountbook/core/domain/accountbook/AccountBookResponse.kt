package com.josh.accountbook.core.domain.accountbook

import java.math.BigDecimal
import java.time.LocalDate

data class AccountBookResponse(
    val id: Long? = null,
    val customerName: Long,
    val accountNumber: Long,
    val bankName: String,
    val amount: BigDecimal,
    val commission: Double,
    val paymentAmount: BigDecimal,
    val paymentDate: LocalDate
) {

}
