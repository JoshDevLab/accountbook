package com.josh.accountbook.core.api.controller.v1

import com.josh.accountbook.core.api.dto.AccountBookRequest
import com.josh.accountbook.core.api.support.response.ApiResponse
import com.josh.accountbook.core.domain.accountbook.AccountBookService
import com.josh.accountbook.security.core.auth.CustomUserInfoDto
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/api/v1/account-book")
class AccountBookController(
    val accountBookService: AccountBookService
) {
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    fun addAccountBook(
        @RequestBody accountBookRequest: List<AccountBookRequest>,
        @AuthenticationPrincipal loginUser: CustomUserInfoDto,
        ): ApiResponse<Int> {
        return ApiResponse.success(accountBookService.addAccountBook(
            accountBookRequest.stream().map { param -> param.toServiceDto() }.toList(), loginUser.id
        ))
    }

    @PutMapping
    @PreAuthorize("hasRole('USER')")
    fun modifyAccountBook(
        @RequestBody accountBookRequest: List<AccountBookRequest>,
    ): ApiResponse<Int> {
        return ApiResponse.success(accountBookService.modifyAccountBook(
            accountBookRequest.stream().map { param -> param.toServiceDto() }.toList()
        ))
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    fun getAccountBooks(
        @RequestParam("customerName", required = false) customerName: String?,
        @RequestParam("accountBookId", required = false) accountBookId: Long?,
        @RequestParam("startYm") startYm: LocalDate,
        @RequestParam("endYm") endYm: LocalDate,
        @RequestParam("limit") limit: Long,
        @AuthenticationPrincipal loginUser: CustomUserInfoDto,
    ): ApiResponse<List<com.josh.accountbook.core.domain.accountbook.AccountBookResponse>> {
        return ApiResponse.success(accountBookService.searchAccountBooks(customerName, accountBookId, startYm, endYm, limit))
    }
}