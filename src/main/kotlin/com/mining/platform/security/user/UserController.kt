package com.mining.platform.security.user

import com.mining.platform.core.controller.AbstractController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.reflect.KClass

/**
 * The User Controller
 *
 * @author luiz.bonfioli
 */
@RestController
@RequestMapping("/api/user") //@Api(value = "user", tags = {"User"})
class UserController : AbstractController<UserEntity, User, UserService>() {
    override val valueObjectClass: KClass<User>
        get() = User::class
}