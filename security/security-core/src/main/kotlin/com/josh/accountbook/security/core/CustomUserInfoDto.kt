package com.josh.accountbook.security.core

import com.josh.accountbook.core.domain.auth.RoleType

data class CustomUserInfoDto(
    val id: Long,
    val email: String,
    val password: String,
    val role: RoleType
)
