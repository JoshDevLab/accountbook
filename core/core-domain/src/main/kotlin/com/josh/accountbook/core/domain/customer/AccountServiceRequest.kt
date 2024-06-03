package com.josh.accountbook.core.domain.customer

data class AccountServiceRequest(
    val customerId: Long,
    val accountNumber: String,
    val bankName: String,
) {
}