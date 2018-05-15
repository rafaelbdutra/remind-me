package com.rafael.dutra.beer.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@EnableWebFlux
public class BeerConfig {

    @Bean
    public RouterFunction<?> queryRouter() {
        return route(GET("/beer"), r -> ServerResponse.ok().body(Mono.just("Corona"), String.class));
    }
}
