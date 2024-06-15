package com.josh.accountbook.core.api.controller.v1

import com.josh.accountbook.core.api.dto.AccountRequest
import com.josh.accountbook.core.api.support.response.ApiResponse
import com.josh.accountbook.core.domain.customer.AccountService
import com.josh.accountbook.security.core.auth.CustomUserInfoDto
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/account")
class AccountController(
    val accountService: AccountService
) {
    @PostMapping("/{customerId}")
    @PreAuthorize("hasRole('USER')")
    fun register(
        @PathVariable("customerId") customerId: Long,
        @RequestBody accountRequest: AccountRequest,
        @AuthenticationPrincipal loginUser: CustomUserInfoDto,
    ): ApiResponse<String> {
        return ApiResponse.success(
            accountService.register(accountRequest.toServiceDto(customerId), loginUser.id).accountNumber
        )
    }

    @PutMapping("{accountId}")
    fun modify(
        @PathVariable accountId: Long,
        @RequestBody accountRequest: AccountRequest
    ): ApiResponse<String> {
        return ApiResponse.success(accountService.modify(accountId, accountRequest.toModifyServiceDto()))
    }

}