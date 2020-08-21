package com.mining.platform.security.user

import com.mining.platform.core.controller.ValueObject
import java.util.*

/**
 * The User Value Object
 *
 * @author luiz.bonfioli
 */
class User : ValueObject<UserEntity> {

    var id: UUID? = null

    override var entity: UserEntity
        get() {
            val entity = UserEntity()
            entity.id = id
            return entity
        }
        set(entity) {
            id = entity.id
        }

    companion object {
        /**
         * Generated Serial
         */
        private const val serialVersionUID = 3199215543210993266L
    }
}