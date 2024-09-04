package com.josh.accountbook.storage.db.core.customer

import com.josh.accountbook.core.domain.customer.Customer
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class CustomerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
) {
    fun toDomain(): Customer {
        return Customer(id!!, name)
    }

    companion object {
        fun create(name: String): CustomerEntity {
            return CustomerEntity(null, name)
        }
    }
}