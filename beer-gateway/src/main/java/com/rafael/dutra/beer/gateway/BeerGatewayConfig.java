package com.rafael.dutra.beer.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@EnableWebFlux
public class BeerGatewayConfig {

//    private WebClient webClient;
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RouterFunction<?> queryRouter() {
        return route(GET("/beer"), r -> ServerResponse.ok().body(Mono.just(lalala()), String.class));
    }

    private String lalala() {
        return restTemplate.exchange("http://BEER-QUERY/query/beer",
                HttpMethod.GET,
                null,
                String.class).getBody();
//        return WebClient.create("http://localhost:8761/beer-query/query/beer").get().retrieve().bodyToMono(String.class);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
