package com.josh.accountbook.core.api.controller.v1

import com.josh.accountbook.core.api.dto.LoginRequestDto
import com.josh.accountbook.core.api.support.response.ApiResponse
import com.josh.accountbook.security.core.auth.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(
    val authService: AuthService
) {
    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequestDto):ApiResponse<String> {
        return ApiResponse.success(authService.login(loginRequest.toServiceDto()))
    }
}