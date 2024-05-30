package com.josh.accountbook.security.core.auth

import com.josh.accountbook.core.domain.auth.MemberRepository
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val memberRepository: MemberRepository,
    private val encoder: PasswordEncoder,
    private val jwtUtil: JwtUtil
) {
    fun login(loginRequest: LoginRequestServiceDto): String {
        val member = (memberRepository.findByEmail(loginRequest.email)
            ?: throw UsernameNotFoundException("가입된 이메일이 없습니다."))

        if (!encoder.matches(loginRequest.password, member.password)) {
            throw BadCredentialsException("비밀번호가 일치하지 않습니다.")
        }

        val info = CustomUserInfoDto(member.id!!, member.email, member.password, member.roleType)

        return jwtUtil.createAccessToken(info)
    }
}