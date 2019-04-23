package com.dutra.remind.me.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Configuration
@EnableWebFlux
public class RemindMeQueryConfig {

    @Autowired
    private ReminderRepository reminderRepository;

    @Bean
    public RouterFunction<ServerResponse> queryRouter() {
        return nest(path("/query/reminder"),
                route(GET("/"), this::allReminders)
                        .andRoute(GET("/{id}"), this::singleReminder));
    }

    private Mono<ServerResponse> allReminders(ServerRequest serverRequest) {
        return reminderRepository.findAll()
                .collectList()
                .flatMap(reminders -> ok().contentType(APPLICATION_JSON).body(fromObject(reminders)));
    }

    private Mono<ServerResponse> singleReminder(ServerRequest request) {
        return Mono.just(request.pathVariable("id"))
                .map(reminderRepository::findById)
                .flatMap(reminder -> ok().contentType(APPLICATION_JSON).body(reminder, Reminder.class))
                .switchIfEmpty(notFound().build())
                .onErrorResume(
                        NumberFormatException.class,
                        e -> status(INTERNAL_SERVER_ERROR).body(fromObject(e.getMessage()))
                )
                .log("here")
                .subscribeOn(Schedulers.elastic());
    }
}
