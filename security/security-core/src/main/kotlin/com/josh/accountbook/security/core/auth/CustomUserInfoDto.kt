package com.josh.accountbook.security.core.auth

import com.josh.accountbook.core.domain.member.RoleType

data class CustomUserInfoDto(
    val id: Long,
    val email: String,
    val password: String,
    val role: RoleType
)
