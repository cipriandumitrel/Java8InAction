package net.java8.part2.chapter6;

import net.java8.part2.Dish;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.reducing;

/**
 * Created by Ciprian on 6/5/2017.
 */

public class Reducing {
    public static void main(String[] args) {
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesWithMethodReference());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesWithoutCollectors());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesUsingSum());
    }

    private static int calculateTotalCaloriesUsingSum() {
        return Dish.menu.stream().mapToInt(Dish::getCalories).sum();
    }

    private static int calculateTotalCaloriesWithoutCollectors() {
        return Dish.menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
    }

    private static int calculateTotalCaloriesWithMethodReference() {
        return Dish.menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
    }

    private static int calculateTotalCalories() {
        return Dish.menu.stream().collect(reducing(0, Dish::getCalories, (a,b) -> a + b));
    }
}
