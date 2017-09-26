package net.java8.part2.chapter5;

import net.java8.part2.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ciprian on 5/28/2017.
 */
public class Mapping {
    public static void main(String[] args) {
        Dish.menu.stream().map(Dish::getName).collect(Collectors.toList()).forEach(System.out::println);

        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream().map(String::length).collect(Collectors.toList());
    }
}
