package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(integer -> System.out.println("intNumberMono when it emits - " + integer));

        // Get the value from the Mono into an integer variable
        Integer integer = ReactiveSources.intNumberMono().block();
        System.out.println("Mono into an integer - " + integer);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
