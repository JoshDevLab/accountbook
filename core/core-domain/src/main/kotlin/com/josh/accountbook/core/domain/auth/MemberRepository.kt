package com.josh.accountbook.core.domain.auth

interface MemberRepository {
    fun findByIdOrNull(id: Long): Member
}