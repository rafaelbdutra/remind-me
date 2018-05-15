package com.rafael.dutra.beer.query;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
@EnableWebFlux
public class BeerQueryConfig {

    @Bean
    public RouterFunction<?> queryRouter() {
        return route(GET("/query/beer"), r -> ok().body(Mono.just("Corona"), String.class));
    }
}
