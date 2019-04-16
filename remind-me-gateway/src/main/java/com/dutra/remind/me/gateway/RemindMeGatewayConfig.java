package com.dutra.remind.me.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@EnableWebFlux
public class RemindMeGatewayConfig {

	public static final String REMIND_ME_QUERY_URL = "http://REMIND-ME-QUERY/query/reminder";

	@Autowired
	private WebClient.Builder webClientBuilder;

	@Bean
	public RouterFunction<?> queryRouter() {
		return route(GET("/reminder"), r -> ServerResponse.ok().body(getAllReminders(), String.class));
	}

	private Mono<String> getAllReminders() {
		return webClientBuilder.build().get().uri(REMIND_ME_QUERY_URL).retrieve().bodyToMono(String.class);
	}

	@Bean
	@LoadBalanced
	WebClient.Builder webClient() {
		return WebClient.builder();
	}
}
