package com.josh.accountbook.core.api.dto

import com.josh.accountbook.core.domain.member.SignUpServiceRequest

data class SignUpRequest(
    val email: String,
    val password: String,
    val name: String
) {
    fun toServiceDto(): SignUpServiceRequest {
        return SignUpServiceRequest(email, password, name)
    }
}