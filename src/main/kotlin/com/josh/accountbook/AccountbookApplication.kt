package com.josh.accountbook

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AccountbookApplication

fun main(args: Array<String>) {
	runApplication<AccountbookApplication>(*args)
}
