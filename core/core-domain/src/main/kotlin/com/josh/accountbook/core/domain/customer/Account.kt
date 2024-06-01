package com.josh.accountbook.core.domain.customer

data class Account(
    val id: Long? = null,
    val customerId: Long,
    val bankName: String,
) {
}