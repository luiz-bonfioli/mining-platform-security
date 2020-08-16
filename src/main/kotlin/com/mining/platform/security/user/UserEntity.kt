package com.mining.platform.security.user

import com.mining.platform.core.audit.AuditListener
import com.mining.platform.core.audit.AuditableEntity
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Where
import java.util.*
import javax.persistence.*

/**
 * The User Entity
 *
 * @author luiz.bonfioli
 */
@Entity
@Table(name = "user")
@Where(clause = "entity_status <> 'DELETED'")
@EntityListeners(AuditListener::class)
class UserEntity : AuditableEntity() {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", unique = true, nullable = false)
    override var id: UUID? = null

    companion object {
        /**
         * Generated Serial
         */
        private const val serialVersionUID = 8323287540967160652L
    }
}