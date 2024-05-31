package com.josh.accountbook.core.api.dto

import com.josh.accountbook.core.domain.customer.CustomerRequestServiceDto

data class CustomerRequestDto(
    val name: String,
    val accountNumber: String,
    val bankName: String
) {
    fun toServiceDto(): CustomerRequestServiceDto {
        return CustomerRequestServiceDto(name, accountNumber, bankName)
    }
}