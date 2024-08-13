package org.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class ReactiveSources {
    public static Flux<String> stringNumberFlux(){
        return Flux.just("one", "tow", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
    }

    public static Flux<Integer> intNumberFlux(){
        return Flux
                .range(1, 10)
                .delayElements(Duration.ofSeconds(1));
    }

    public static Mono<Integer> intNumberMono(){
        return Mono.just(42)
                .delayElement(Duration.ofSeconds(1));
    }

    public static Flux<Integer> intNumberFluxWithException(){
        return Flux
                .range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .map(e -> {
                    if(e == 5) throw new RuntimeException("An error happened in the flux");
                    return e;
                });
    }

    public static Flux<User> userFlux(){
        return Flux.just(
                new User(1, "Lional", "Messi"),
                new User(2, "Cristiano", "Ronaldo"),
                new User(3, "Diego", "Maradona"),
                new User (4, "Zinedine", "Zidane"),
                new User(5, "Jürgen", "Klinsmann"),
                new User(6, "Gareth", "Bale")
        ).delayElements(Duration.ofSeconds(1));
    }

    public static Mono<User> userMono(){
        return Mono.just(
                new User(1, "Lionel", "Messi")
        ).delayElement(Duration.ofSeconds(1));
    }

    public static Flux<String> unresponsiveFlux(){
        return Flux.never();
    }

    public static Mono<String> unresponsiveMono(){
        return Mono.never();
    }

    public static Flux<Integer> intNumberFluxWithRepeat(){
        return Flux
                .just(1,2,1,1, 3,2, 4, 5, 1)
                .delayElements(Duration.ofSeconds(1));
    }
}
