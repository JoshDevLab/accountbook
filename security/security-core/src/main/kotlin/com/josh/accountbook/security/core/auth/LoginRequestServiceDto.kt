package com.josh.accountbook.security.core.auth

data class LoginRequestServiceDto(
    val username: String,
    val password: String
)
