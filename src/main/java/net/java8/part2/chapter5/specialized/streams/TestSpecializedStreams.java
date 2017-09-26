package net.java8.part2.chapter5.specialized.streams;

import net.java8.part2.Dish;

/**
 * Created by Ciprian on 6/4/2017.
 */

public class TestSpecializedStreams {
    public static void main(String[] args) {
        //sum of calories without specialized streams
        int totalNumberOfCalories = Dish.menu.stream().map(Dish::getCalories).reduce(0, (d1, d2) -> d1 + d2);
        System.out.println("Total number of calories " + totalNumberOfCalories);

        //sum of calories with specialized streams
        int totalNumberOfCaloriesWithSpecialized = Dish.menu.stream()
                .mapToInt(Dish::getCalories).sum();
        System.out.println("Total number of calories with specialized streams " + totalNumberOfCaloriesWithSpecialized);
    }
}
