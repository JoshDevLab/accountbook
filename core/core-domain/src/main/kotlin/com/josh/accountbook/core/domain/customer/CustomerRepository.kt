package com.josh.accountbook.core.domain.customer

interface CustomerRepository {
    fun save(name: String, memberId: Long): Customer
}