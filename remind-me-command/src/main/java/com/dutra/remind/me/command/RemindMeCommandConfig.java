package com.dutra.remind.me.command;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
@EnableWebFlux
public class RemindMeCommandConfig {

    // inject kafka producer

    @Bean
    public RouterFunction<ServerResponse> queryRouter() {
        return nest(path("/reminder"),
                route(POST("/"), this::createReminder));
    }

    private Mono<ServerResponse> createReminder(ServerRequest serverRequest) {
        // extract body to POJO
//        serverRequest.body()

        // generate uuid
        UUID messageId = UUID.randomUUID();

        // send message to kafka

        // return generated id

//        return reminderRepository.findAll()
//                .collectList()
//                .flatMap(reminders -> ok().contentType(APPLICATION_JSON).body(fromObject(reminders)));
        return null;
    }
}
