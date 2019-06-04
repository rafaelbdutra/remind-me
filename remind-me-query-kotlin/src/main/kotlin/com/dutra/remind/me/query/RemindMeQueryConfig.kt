package com.dutra.remind.me.query

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import java.util.*

@Configuration
@EnableWebFlux
class RemindMeQueryConfig {

    @Autowired
    lateinit var reminderRepository: ReminderRepository

    @Bean
    fun queryRouter() = router {
        "/query/reminders".nest {
            GET("/", ::allReminders )
            GET("/{id}", ::singleReminder)
        }
    }

    private fun allReminders(request : ServerRequest) =
            reminderRepository.findAll()
                    .collectList()
                    .flatMap { reminder -> ok().contentType(APPLICATION_JSON).body(fromObject(reminder)) }

    private fun singleReminder(request: ServerRequest) =
            Mono.just(request.pathVariable("id"))
                    .map(UUID::fromString)
                    .map(reminderRepository::findById)
                    .flatMap { reminder -> ok().contentType(APPLICATION_JSON).body(reminder, Reminder::class.java) }
                    .switchIfEmpty(notFound().build())
                    .onErrorResume(NumberFormatException::class.java) {
                        e -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).body(fromObject(e.localizedMessage))
                    }
                    .subscribeOn(Schedulers.elastic())

}
