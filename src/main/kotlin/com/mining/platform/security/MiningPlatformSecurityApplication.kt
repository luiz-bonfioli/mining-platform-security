package com.mining.platform.security

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan("com.mining.platform.security", "com.mining.platform.core")
@EnableJpaRepositories("com.mining.platform.security", "com.mining.platform.core")
@EntityScan("com.mining.platform.security", "com.mining.platform.core")
class MiningPlatformSecurityApplication

fun main(args: Array<String>) {
    runApplication<MiningPlatformSecurityApplication>(*args)
}
