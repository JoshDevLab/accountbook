package com.josh.accountbook.storage.db.core.accountbook

import org.springframework.data.jpa.repository.JpaRepository

interface AccountBookJpaRepository: JpaRepository<AccountBookEntity, Long> {
}