package com.josh.accountbook.storage.db.core.member

import com.josh.accountbook.core.domain.auth.Member
import com.josh.accountbook.core.domain.auth.MemberRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class MemberCoreRepository(
    val memberJpaRepository: MemberJpaRepository
): MemberRepository {
    override fun findByIdOrNull(id: Long): Member {
        memberJpaRepository.findByIdOrNull(id)
            ?.let {
                return it.toDomain()
            }
            ?: throw NotFoundException()
    }
}