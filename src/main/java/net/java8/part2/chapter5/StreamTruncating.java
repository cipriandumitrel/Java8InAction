package net.java8.part2.chapter5;

import net.java8.part2.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ciprian on 5/17/2017.
 */

public class StreamTruncating {

    public static void main(String[] args) {
        List<Dish> dishes = Dish.menu.stream()
                                     .filter(d -> d.getCalories() > 300)
                                     .limit(3)
                                     .collect(Collectors.toList());

        dishes.forEach(System.out::println);
    }
}
