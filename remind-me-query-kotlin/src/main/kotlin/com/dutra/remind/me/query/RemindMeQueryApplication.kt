package com.dutra.remind.me.query

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class RemindMeQueryApplication

fun main() {
    runApplication<RemindMeQueryApplication>()
}