package com.josh.accountbook.core.domain.customer

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerHelper: CustomerHelper,
    val accountHelper: AccountHelper
) {
    fun register(name: String, memberId: Long): String {
        return customerHelper.register(name, memberId)
    }
}