package com.josh.accountbook.storage.db.core.member

import com.josh.accountbook.core.domain.member.Member
import com.josh.accountbook.core.domain.member.RoleType
import com.josh.accountbook.core.domain.member.SignUpServiceRequest
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

    companion object {
        fun registerNewMember(signUpRequest: SignUpServiceRequest):MemberEntity {
            return MemberEntity(null, signUpRequest.email, signUpRequest.name, signUpRequest.password, RoleType.USER)
        }
    }

}