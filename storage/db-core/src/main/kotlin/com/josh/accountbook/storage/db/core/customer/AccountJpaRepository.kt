package com.josh.accountbook.storage.db.core.customer

import org.springframework.data.jpa.repository.JpaRepository

interface AccountJpaRepository: JpaRepository<AccountEntity, Long> {
}