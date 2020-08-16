package com.mining.platform.security.user

import com.mining.platform.core.datasource.AbstractRepository
import java.util.*

/**
 * The User Repository
 *
 * @author luiz.bonfioli
 */
interface UserRepository : AbstractRepository<UserEntity, UUID>