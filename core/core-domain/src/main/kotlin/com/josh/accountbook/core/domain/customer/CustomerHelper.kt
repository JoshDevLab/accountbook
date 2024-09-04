package com.josh.accountbook.core.domain.customer

import org.springframework.stereotype.Component

@Component
class CustomerHelper(
    val customerRepository: CustomerRepository
) {
    fun register(name: String): String {
        return customerRepository.save(name).name
    }
}