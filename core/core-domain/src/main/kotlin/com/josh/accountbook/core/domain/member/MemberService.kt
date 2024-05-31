package com.josh.accountbook.core.domain.member

import com.josh.accountbook.error.DuplicateEmailException
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberHelper: MemberHelper
) {

    fun signUp(signUpRequest: SignUpServiceRequest): String {
        if (memberHelper.checkDuplicateEmail(signUpRequest.email)) {
            throw DuplicateEmailException("이미 가입한 이메일입니다.")
        }
        return memberHelper.signUp(signUpRequest)
    }
}