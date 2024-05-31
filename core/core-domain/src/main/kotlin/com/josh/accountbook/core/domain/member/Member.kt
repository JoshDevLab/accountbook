package com.josh.accountbook.core.domain.member

data class Member(
    val id: Long? = null,
    val email: String,
    val name: String,
    val password: String,
    val roleType: RoleType
) {
}