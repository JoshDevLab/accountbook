package com.josh.accountbook.storage.db.core.member

import org.springframework.data.jpa.repository.JpaRepository

interface MemberJpaRepository: JpaRepository<MemberEntity, Long> {
    fun findByEmail(username: String): MemberEntity?
    fun existsByEmail(username: String): Boolean
}