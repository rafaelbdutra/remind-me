package com.dutra.remind.me.gateway

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono

@Configuration
@EnableWebFlux
class RemindMeGatewayConfig {

    companion object {
        @JvmField
        var REMIND_ME_QUERY_URL = "http://REMIND-ME-QUERY/query/reminder"
    }

    @Autowired
    lateinit var webClientBuilder: WebClient.Builder

    @Bean
    fun queryRouter() = router {
        GET("/reminder") { _ -> ServerResponse.ok().body(getAllReminders(), String::class.java) }
    }

    private fun getAllReminders(): Mono<String> = webClientBuilder.build().get().uri(REMIND_ME_QUERY_URL).retrieve().bodyToMono(String::class.java)

    @Bean
    @LoadBalanced
    fun webClient(): WebClient.Builder = WebClient.builder()
}
