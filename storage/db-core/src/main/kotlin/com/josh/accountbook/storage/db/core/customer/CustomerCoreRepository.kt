package com.josh.accountbook.storage.db.core.customer

import com.josh.accountbook.core.domain.customer.Customer
import com.josh.accountbook.core.domain.customer.CustomerRepository
import org.springframework.stereotype.Repository

@Repository
class CustomerCoreRepository(
    private val customerJpaRepository: CustomerJpaRepository
): CustomerRepository {
    override fun save(name: String, memberId: Long): Customer {
        return customerJpaRepository.save(CustomerEntity.create(name, memberId)).toDomain()
    }

}