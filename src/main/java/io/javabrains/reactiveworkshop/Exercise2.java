package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        ReactiveSources.intNumbersFlux().subscribe(i -> System.out.println(i));

        // Print all users in the ReactiveSources.userFlux stream
//        ReactiveSources.stringNumbersFlux().subscribe(s -> System.out.println(s));
        ReactiveSources.userFlux().subscribe(user -> System.out.println(user.toString()));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
