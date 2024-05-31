package com.josh.accountbook.core.api.controller

import com.josh.accountbook.core.api.dto.SignUpRequest
import com.josh.accountbook.core.api.support.response.ApiResponse
import com.josh.accountbook.core.domain.member.MemberService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/member")
class MemberController(
    val memberService: MemberService
) {
    @PostMapping("/signUp")
    fun signUp(@RequestBody signUpRequest: SignUpRequest): ApiResponse<String> {
        return ApiResponse.success(memberService.signUp(signUpRequest.toServiceDto()))
    }

}