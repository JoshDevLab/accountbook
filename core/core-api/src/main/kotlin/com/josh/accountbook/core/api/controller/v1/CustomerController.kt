package com.josh.accountbook.core.api.controller.v1

import com.josh.accountbook.core.api.support.response.ApiResponse
import com.josh.accountbook.core.domain.customer.CustomerService
import com.josh.accountbook.security.core.auth.CustomUserInfoDto
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customer")
class CustomerController(
    val customerService: CustomerService
) {
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    fun register(
        @RequestParam("name") name: String,
        @AuthenticationPrincipal loginUser: CustomUserInfoDto,
    ): ApiResponse<String> {
        return ApiResponse.success(customerService.register(name))
    }
}