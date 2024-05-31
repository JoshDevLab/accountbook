package com.josh.accountbook.storage.db.core.member

import com.josh.accountbook.core.domain.member.Member
import com.josh.accountbook.core.domain.member.MemberRepository
import com.josh.accountbook.core.domain.member.SignUpServiceRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class MemberCoreRepository(
    val memberJpaRepository: MemberJpaRepository
): MemberRepository {
    override fun findByIdOrNull(id: Long): Member? {
        memberJpaRepository.findByIdOrNull(id)
            ?.let {
                return it.toDomain()
            }
            ?: return null
    }

    override fun findByEmail(email: String): Member? {
        return memberJpaRepository.findByEmail(email)
            ?.let {
                return it.toDomain()
            }
            ?: return null
    }

    override fun save(signUpRequest: SignUpServiceRequest): String {
        val registerNewMember = MemberEntity.registerNewMember(signUpRequest)
        return memberJpaRepository.save(registerNewMember).name
    }

    override fun existsByEmail(email: String): Boolean {
        return memberJpaRepository.existsByEmail(email)
    }

}