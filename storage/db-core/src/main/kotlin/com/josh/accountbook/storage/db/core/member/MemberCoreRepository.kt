package com.josh.accountbook.storage.db.core.member

import com.josh.accountbook.core.domain.auth.MemberRepository
import org.springframework.stereotype.Repository

@Repository
class MemberCoreRepository(
    val memberJpaRepository: MemberJpaRepository
): MemberRepository {
}