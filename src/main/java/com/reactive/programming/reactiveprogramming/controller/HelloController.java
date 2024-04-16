package com.reactive.programming.reactiveprogramming.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping(path= "/mono")
    public Mono<String> getMono() {
        return Mono.just("Wellcome");
    }
    
    @GetMapping(path = "/flux")
    public Flux<String> getFlux() {
        return Flux.just("This", "is", "the", "flux", "response")
                .delayElements(Duration.ofSeconds(1)).log();
    }
}
