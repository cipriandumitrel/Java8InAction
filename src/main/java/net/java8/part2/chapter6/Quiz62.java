package net.java8.part2.chapter6;

import net.java8.part2.Dish;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

/**
 * Created by Ciprian on 6/6/2017.
 */

public class Quiz62 {
    public static void main(String[] args) {
        System.out.println("Question1: " + question1());
        System.out.println("Question2: " + question2());
    }

    private static Object question2() {
        return Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian,
                counting()));
    }

    private static Map<Boolean, Map<Boolean, List<Dish>>> question1() {
        return Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian, partitioningBy(d->d.getCalories() > 500)));
    }
}
