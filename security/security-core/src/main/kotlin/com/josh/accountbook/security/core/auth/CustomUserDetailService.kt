package com.josh.accountbook.security.core.auth

import com.josh.accountbook.core.domain.member.MemberRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class CustomUserDetailService(
    private val memberRepository: MemberRepository
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val member = memberRepository.findByIdOrNull(username.toLong())
            ?: throw UsernameNotFoundException("유저가 없습니다.")
        return CustomUserDetails(CustomUserInfoDto(member.id!!, member.email, member.password, member.roleType))
    }
}