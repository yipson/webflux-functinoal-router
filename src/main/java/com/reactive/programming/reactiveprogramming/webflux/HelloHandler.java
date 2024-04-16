package com.reactive.programming.reactiveprogramming.webflux;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class HelloHandler {

    public Mono<ServerResponse> monoMessage(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(
                        Mono.just("Wellcome"), String.class
                );
    }

    public Mono<ServerResponse> fluxMessage(ServerRequest serverRequest) {
        return ServerResponse.ok()
//                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(
                        Flux.just("Welcome ", "to ", "my ", "RestAPI")
                                .delayElements(Duration.ofSeconds(1)), String.class
                );
    }
}
