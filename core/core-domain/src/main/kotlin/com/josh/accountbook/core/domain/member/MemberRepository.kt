package com.josh.accountbook.core.domain.member

interface MemberRepository {
    fun findByIdOrNull(id: Long): Member?
    fun findByUsername(username: String): Member?
    fun save(signUpRequest: SignUpServiceRequest): String
    fun existsByEmail(username: String): Boolean
}