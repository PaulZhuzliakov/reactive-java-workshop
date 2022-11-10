package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise9 {
    private static final int BUFFER_SIZE = 2;

    public static void main(String[] args) throws IOException {


        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
//        ReactiveSources.intNumbersFlux()
//                .count()
//                .subscribe(aLong -> System.out.println(aLong));

        // Collect all items of intNumbersFlux into a single list and print it
//        ReactiveSources.intNumbersFlux()
//                .collectList()
//                .subscribe(i -> System.out.println(i));

        // Transform to a sequence of sums of adjacent two numbers

        ReactiveSources.intNumbersFlux()
                .buffer(BUFFER_SIZE)
                .map(integers -> {
                    int int1 = integers.get(0);
                    int int2;
                    if (integers.size() == BUFFER_SIZE) {
                        int2 = integers.get(1);
                    } else {
                        int2 = 0;
                    }
                    return int1 + int2;
                })
                .subscribe(integer -> System.out.println(integer));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
