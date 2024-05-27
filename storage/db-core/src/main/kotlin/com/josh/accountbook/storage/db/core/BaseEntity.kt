package com.josh.accountbook.storage.db.core

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {
    @CreationTimestamp
    @Column(updatable = false)
    val createdDate: LocalDateTime?=null
    @UpdateTimestamp
    @Column
    var modifiedDate: LocalDateTime?=null
        protected set
}
