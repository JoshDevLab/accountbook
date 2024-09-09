package com.josh.accountbook.core.api.controller.v1

import com.josh.accountbook.core.api.dto.LoginRequest
import com.josh.accountbook.core.api.dto.SignUpRequest
import com.josh.accountbook.core.api.support.response.ApiResponse
import com.josh.accountbook.core.domain.member.MemberService
import com.josh.accountbook.security.core.auth.AuthService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(
    val authService: AuthService,
    val memberService: MemberService,
    private val encoder: PasswordEncoder
) {

    @PostMapping("/signUp")
    fun signUp(@RequestBody signUpRequest: SignUpRequest): ApiResponse<String> {
        signUpRequest.password = encoder.encode(signUpRequest.password)
        return ApiResponse.success(memberService.signUp(signUpRequest.toServiceDto()))
    }

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest):ApiResponse<String> {
        return ApiResponse.success(authService.login(loginRequest.toServiceDto()))
    }

}