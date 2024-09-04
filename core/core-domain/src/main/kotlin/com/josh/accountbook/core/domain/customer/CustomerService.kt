package com.josh.accountbook.core.domain.customer

import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerHelper: CustomerHelper,
    val accountHelper: AccountHelper
) {
    fun register(name: String): String {
        return customerHelper.register(name)
    }
}