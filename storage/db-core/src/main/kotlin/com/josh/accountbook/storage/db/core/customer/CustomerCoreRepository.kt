package com.josh.accountbook.storage.db.core.customer

import com.josh.accountbook.core.domain.customer.Customer
import com.josh.accountbook.core.domain.customer.CustomerRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository

@Repository
class CustomerCoreRepository(
    private val customerJpaRepository: CustomerJpaRepository
): CustomerRepository {
    override fun save(name: String): Customer {
        return customerJpaRepository.save(CustomerEntity.create(name)).toDomain()
    }

}