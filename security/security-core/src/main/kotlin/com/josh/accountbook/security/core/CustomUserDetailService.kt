package com.josh.accountbook.security.core

import com.josh.accountbook.core.domain.auth.MemberRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class CustomUserDetailService(
    private val memberRepository: MemberRepository
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val member = memberRepository.findByIdOrNull(username.toLong())
        return CustomUserDetails(CustomUserInfoDto(member.id!!, member.email, member.password, member.roleType))
    }
}