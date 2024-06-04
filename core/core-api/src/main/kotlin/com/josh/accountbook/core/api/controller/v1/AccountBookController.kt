package com.josh.accountbook.core.api.controller.v1

import com.josh.accountbook.core.api.dto.AccountBookRequest
import com.josh.accountbook.core.api.dto.AccountBookResponse
import com.josh.accountbook.core.api.support.response.ApiResponse
import com.josh.accountbook.core.domain.accountbook.AccountBookService
import com.josh.accountbook.security.core.auth.CustomUserInfoDto
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/account-book")
class AccountBookController(
    val accountBookService: AccountBookService
) {
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    fun addAccountBook(
        @RequestBody accountBookRequest: AccountBookRequest,
        @AuthenticationPrincipal loginUser: CustomUserInfoDto,
        ):ApiResponse<String> {
        return ApiResponse.success(accountBookService.addAccountBook(accountBookRequest.toServiceDto(), loginUser.id))
    }
}