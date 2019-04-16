package com.rafael.dutra.beer.gateway;

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
public class BeerGatewayConfig {

	public static final String BEER_QUERY_URL = "http://BEER-QUERY/query/beer";

	@Autowired
	private WebClient.Builder webClientBuilder;

	@Bean
	public RouterFunction<?> queryRouter() {
		return route(GET("/beer"), r -> ServerResponse.ok().body(getAllBeers(), String.class));
	}

	private Mono<String> getAllBeers() {
		return webClientBuilder.build().get().uri(BEER_QUERY_URL).retrieve().bodyToMono(String.class);
	}

	@Bean
	@LoadBalanced
	WebClient.Builder webClient() {
		return WebClient.builder();
	}
}
