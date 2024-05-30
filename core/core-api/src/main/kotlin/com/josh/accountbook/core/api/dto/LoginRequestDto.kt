package com.josh.accountbook.core.api.dto

import com.josh.accountbook.security.core.auth.LoginRequestServiceDto

data class LoginRequestDto(
    val email: String,
    val password: String
) {
    fun toServiceDto(): LoginRequestServiceDto {
       return LoginRequestServiceDto(email, password)
    }
}