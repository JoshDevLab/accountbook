package com.josh.accountbook.core.domain.customer

import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerHelper: CustomerHelper
) {
    fun register(customerRequest: CustomerRequestServiceDto): String {
        return customerHelper.register(customerRequest)
    }
}