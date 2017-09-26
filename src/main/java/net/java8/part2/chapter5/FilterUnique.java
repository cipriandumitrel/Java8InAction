package net.java8.part2.chapter5;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ciprian on 5/17/2017.
 */

public class FilterUnique {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }
}
