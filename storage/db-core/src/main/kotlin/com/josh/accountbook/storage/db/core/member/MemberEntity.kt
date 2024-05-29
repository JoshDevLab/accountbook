package com.josh.accountbook.storage.db.core.member

import com.josh.accountbook.core.domain.auth.Member
import com.josh.accountbook.core.domain.auth.RoleType
import jakarta.persistence.*

@Entity
@Table(name = "MEMBER")
class MemberEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val email: String,
    val name: String,
    val password: String,

    @Enumerated
    val roleType: RoleType
) {
    fun toDomain(): Member {
        return Member(id, email, name, password, roleType)
    }

}