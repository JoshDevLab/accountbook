package com.josh.accountbook.core.domain.customer

class Account(
    val id: Long? = null,
    val customerId: Long,
    val accountNumber: String,
    val bankName: String,
) {
}