package com.josh.accountbook.core.domain.member

data class SignUpServiceRequest(
    val email: String,
    val password: String,
    val name: String
) {

}