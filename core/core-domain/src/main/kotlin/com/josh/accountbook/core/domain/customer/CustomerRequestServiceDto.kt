package com.josh.accountbook.core.domain.customer

data class CustomerRequestServiceDto(
    val name: String,
    val accountNumber: String,
    val bankName: String
) {
}