package com.josh.accountbook.error

class DuplicateEmailException(
    override val message: String
): RuntimeException(message) {
}