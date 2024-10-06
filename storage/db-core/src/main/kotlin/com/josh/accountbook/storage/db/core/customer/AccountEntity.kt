package com.josh.accountbook.storage.db.core.customer

import com.josh.accountbook.core.domain.customer.Account
import com.josh.accountbook.core.domain.customer.AccountServiceRequest
import jakarta.persistence.*

@Entity
@Table(name = "account")
class AccountEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val customerId: Long,
    val accountNumber: String,
    val bankName: String
) {
    fun toDomain(): Account {
        return Account(id, customerId, accountNumber, bankName)
    }

    companion object {
        fun create(accountRequest: AccountServiceRequest): AccountEntity {
            return AccountEntity(null, accountRequest.customerId!!, accountRequest.accountNumber, accountRequest.bankName)
        }
    }
}