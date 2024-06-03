package com.josh.accountbook.core.api.dto

import com.josh.accountbook.core.domain.customer.AccountServiceRequest

data class AccountRequest(
    val accountNumber: String,
    val bankName: String
) {
    fun toServiceDto(customerId: Long): AccountServiceRequest {
        return AccountServiceRequest(customerId, accountNumber, bankName)
    }
}
