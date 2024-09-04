package com.josh.accountbook.storage.db.core.customer

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface AccountJpaRepository: JpaRepository<AccountEntity, Long> {

    @Modifying
    @Query("update AccountEntity a set a.accountNumber = :accountNumber, " +
            "a.bankName = :bankName where a.id = :accountId ")
    fun update(
        @Param("accountId") accountId: Long,
        @Param("accountNumber") accountNumber: String,
        @Param("bankName") bankName: String
    ): String
}