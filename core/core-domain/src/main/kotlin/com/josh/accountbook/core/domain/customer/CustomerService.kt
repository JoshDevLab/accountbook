package com.josh.accountbook.core.domain.customer

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerHelper: CustomerHelper,
    val accountHelper: AccountHelper
) {
    @Transactional
    fun register(customerRequest: CustomerRequestServiceDto, memberId: Long): String {
        if (accountHelper.existByAccountNumberMemberId(customerRequest.accountNumber, memberId)) {
            throw IllegalArgumentException("이미 존재하는 계좌입니다.")
        }
        return customerHelper.register(customerRequest)
    }
}