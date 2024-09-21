package com.josh.accountbook.core.api.controller

import com.josh.accountbook.core.api.support.error.CoreApiException
import com.josh.accountbook.core.api.support.error.ErrorType
import com.josh.accountbook.core.api.support.response.ApiResponse
import com.josh.accountbook.error.DuplicateEmailException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.logging.LogLevel
import org.springframework.http.ResponseEntity
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiControllerAdvice {
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(CoreApiException::class)
    fun handleCoreApiException(e: CoreApiException): ResponseEntity<ApiResponse<Any>> {
        when (e.errorType.logLevel) {
            LogLevel.ERROR -> log.error("CoreApiException : {}", e.message, e)
            LogLevel.WARN -> log.warn("CoreApiException : {}", e.message, e)
            else -> log.info("CoreApiException : {}", e.message, e)
        }
        return ResponseEntity(ApiResponse.error(e.errorType, e.data), e.errorType.status)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ApiResponse<Any>> {
        log.error("Exception : {}", e.message, e)
        return ResponseEntity(ApiResponse.error(ErrorType.DEFAULT_ERROR), ErrorType.DEFAULT_ERROR.status)
    }

    @ExceptionHandler(DuplicateEmailException::class)
    fun duplicateEmailException(e: Exception): ResponseEntity<ApiResponse<Any>> {
        log.error("duplicateEmailException : {}", e.message, e)
        return ResponseEntity(ApiResponse.error(ErrorType.CLIENT_ERROR, e.message), ErrorType.CLIENT_ERROR.status)
    }

    @ExceptionHandler(UsernameNotFoundException::class)
    fun userNotFoundException(e: Exception): ResponseEntity<ApiResponse<Any>> {
        log.error("userNotFoundException : {}", e.message, e)
        return ResponseEntity(ApiResponse.error(ErrorType.CLIENT_ERROR, e.message), ErrorType.CLIENT_ERROR.status)
    }

}
