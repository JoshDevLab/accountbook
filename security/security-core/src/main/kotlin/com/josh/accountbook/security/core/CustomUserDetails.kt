package com.josh.accountbook.security.core

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.stream.Collectors


class CustomUserDetails(
    private val member: CustomUserInfoDto
): UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val roles: MutableList<String> = ArrayList()
        roles.add("ROLE_" + member.role.toString())


        return roles.stream()
            .map { role: String? ->
                SimpleGrantedAuthority(
                    role
                )
            }
            .collect(Collectors.toList())
    }

    override fun getPassword(): String {
        return member.password
    }

    override fun getUsername(): String {
        return member.id.toString()
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}