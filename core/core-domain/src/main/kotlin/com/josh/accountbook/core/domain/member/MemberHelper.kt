package com.josh.accountbook.core.domain.member

import org.springframework.stereotype.Component

@Component
class MemberHelper(
    private val memberRepository: MemberRepository
) {
    fun signUp(signUpRequest: SignUpServiceRequest): String {
        return memberRepository.save(signUpRequest)
    }

    fun checkDuplicateEmail(username: String): Boolean {
        return memberRepository.existsByEmail(username)
    }
}