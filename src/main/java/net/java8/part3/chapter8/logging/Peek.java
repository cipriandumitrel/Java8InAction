package net.java8.part3.chapter8.logging;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Ciprian on 10/31/2017.
 */

public class Peek {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);
        numbers.stream()
                .map(x -> x + 17)
                .filter(x -> x % 2 == 0)
                .limit(3)
                .forEach(System.out::println);

        System.out.println("------------------------------");

        List<Integer> result =
                numbers.stream()
                        .peek(x -> System.out.println("from stream: " + x))
                        .map(x -> x + 17)
                        .peek(x -> System.out.println("after map: " + x))
                        .filter(x -> x % 2 == 0)
                        .peek(x -> System.out.println("after filter: " + x))
                        .limit(3)
                        .peek(x -> System.out.println("after limit: " + x))
                        .collect(toList());
    }

}
