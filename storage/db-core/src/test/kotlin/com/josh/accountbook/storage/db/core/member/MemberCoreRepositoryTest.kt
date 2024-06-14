package com.josh.accountbook.storage.db.core.member

import com.josh.accountbook.core.domain.member.SignUpServiceRequest
import com.josh.accountbook.storage.db.CoreDbContextTest
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class MemberCoreRepositoryTest(
): CoreDbContextTest() {

    @Autowired
    lateinit var memberCoreRepository: MemberCoreRepository

    @DisplayName("멤버를 생성할 수 있다.")
    @Test
    fun save() {
        //given
        val signUpServiceRequest = SignUpServiceRequest("test@test.com", "qwer1234$", "test")

        //when
        val name = memberCoreRepository.save(signUpServiceRequest)

        //then
        assertThat(name).isEqualTo("test")
    }

    @DisplayName("멤버의 id를 통해 멤버를 찾을 수 있다.")
    @Test
    fun findByIdOrNull() {
        //given
        val signUpServiceRequest = SignUpServiceRequest("test@test.com", "qwer1234$", "test")
        val name = memberCoreRepository.save(signUpServiceRequest)

        //when
        val member = memberCoreRepository.findByIdOrNull(1L)

        //then
        assertThat(member?.email).isEqualTo("test@test.com")
        assertThat(member?.name).isEqualTo("test")
    }
}