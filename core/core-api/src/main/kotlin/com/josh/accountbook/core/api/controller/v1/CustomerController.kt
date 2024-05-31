package com.josh.accountbook.core.api.controller.v1

import com.josh.accountbook.core.api.dto.CustomerRequestDto
import com.josh.accountbook.core.api.support.response.ApiResponse
import com.josh.accountbook.core.domain.customer.CustomerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customer")
class CustomerController(
    val customerService: CustomerService
) {
    @PostMapping
    fun register(customerRequestDto: CustomerRequestDto): ApiResponse<String> {
        return ApiResponse.success(customerService.register(customerRequestDto.toServiceDto()))
    }
}