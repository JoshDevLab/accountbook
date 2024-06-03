package com.josh.accountbook.core.domain.customer

import org.springframework.stereotype.Component

@Component
class CustomerHelper(
    val customerRepository: CustomerRepository
) {
    fun register(name: String, memberId: Long): String {
        return customerRepository.save(name, memberId).name
    }
}