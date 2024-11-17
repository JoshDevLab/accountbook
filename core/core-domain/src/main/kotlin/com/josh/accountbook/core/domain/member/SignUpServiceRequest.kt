package com.josh.accountbook.core.domain.member

data class SignUpServiceRequest(
    val username: String,
    val password: String,
    val name: String,
    val nickname: String,
) {

}