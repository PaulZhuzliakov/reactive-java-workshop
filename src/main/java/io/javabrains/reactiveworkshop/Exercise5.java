package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumbersFlux().subscribe(
                integer -> System.out.println(integer),
                throwable -> System.out.println(throwable.getMessage()),
                () -> System.out.println("end of intNumbersFlux")
        );

        ReactiveSources.userFlux().subscribe(
                user -> System.out.println(user),
                throwable -> System.out.println(throwable.getMessage()),
                () -> System.out.println("end of userFlux")
        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(
                new MySubscriber<>()
        );

        ReactiveSources.userFlux().subscribe(
                new MySubscriber<>()
        );

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {
    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("subscription happend");
        request(2);
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.println(value.toString() + " reseived");
        request(2);
    }

    @Override
    protected void hookOnComplete() {
        System.out.println("completed");
    }
}