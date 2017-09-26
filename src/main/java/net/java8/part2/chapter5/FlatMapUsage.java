package net.java8.part2.chapter5;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by Ciprian on 5/28/2017.
 */
public class FlatMapUsage {

    public static void main(String[] args) {
        String [] words = {"Hello", "World"};

        Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList())
                .forEach(System.out::println);
    }
}
