package com.josh.accountbook.storage.db.core

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity: BaseTimeEntity() {

    @CreatedBy
    @Column(updatable = false)
    val createdBy: LocalDateTime? = null

    @LastModifiedBy
    var lastModifiedBy: String? = null
}
