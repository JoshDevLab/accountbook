package com.josh.accountbook.security.core.auth

data class LoginRequestServiceDto(
    val email: String,
    val password: String
)
