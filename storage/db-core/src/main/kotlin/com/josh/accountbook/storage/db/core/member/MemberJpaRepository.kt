package com.josh.accountbook.storage.db.core.member

import org.springframework.data.jpa.repository.JpaRepository

interface MemberJpaRepository: JpaRepository<MemberEntity, Long> {
    fun findByUsername(username: String): MemberEntity?
    fun existsByUsername(username: String): Boolean
}