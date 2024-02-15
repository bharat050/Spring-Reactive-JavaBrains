package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumbersFlux().subscribe(
                num -> System.out.println(num),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Stream Completion")
        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {

    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscription Made");
        request(3); // number of maximum request that can be handled by Subscriber whenever the data ready.
    }

    public void hookOnNext(T val) {
        System.out.println(val + " val received");
        request(1);
    }
    // similarly we can create another hooks for error and completion as they are terminal
    // operation request keyword not likely
}