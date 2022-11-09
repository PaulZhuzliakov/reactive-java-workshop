package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        System.out.println("Print all numbers in the ReactiveSources.intNumbersFlux stream");
        Flux<Integer> integerFlux = ReactiveSources.intNumbersFlux();
        integerFlux.subscribe(integer -> System.out.println(integer));
        System.out.println("-----------------------------------");

        // Print all users in the ReactiveSources.userFlux stream
        System.out.println("Print all users in the ReactiveSources.userFlux stream");
        Flux<User> userFlux = ReactiveSources.userFlux();
        userFlux.subscribe(user -> System.out.println(user));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
