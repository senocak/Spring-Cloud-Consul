package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties
@EnableScheduling
class KApp(private val userProp: UserProp){

    @Scheduled(fixedRate = 3_000)
    fun reportCurrentTime() {
        println("configFromValue: $userProp")
    }
}

fun main(args: Array<String>) {
    runApplication<KApp>(*args)
}

@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "api")
data class UserProp(
    var username: String? = null,
    var password: String? = null
){
    override fun toString(): String = "UserProp(username=$username, password=$password)"
}
