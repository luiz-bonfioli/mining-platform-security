package com.mining.platform.security.user

import com.mining.platform.core.service.AbstractService
import com.mining.platform.core.service.DataService
import org.springframework.stereotype.Service

/**
 * The User Service
 *
 * @author luiz.bonfioli
 */
@Service
class UserService : AbstractService<UserEntity, UserRepository>(), DataService<UserEntity>