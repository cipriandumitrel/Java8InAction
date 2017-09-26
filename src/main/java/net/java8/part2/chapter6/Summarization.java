package net.java8.part2.chapter6;

import net.java8.part2.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;

import static java.util.stream.Collectors.*;

/**
 * Created by Ciprian on 6/5/2017.
 */

public class Summarization {

    public static void main(String... args) {
        System.out.println("Nr. of dishes: " + howManyDishes());
        System.out.println("The most caloric dish is: " + findMostCaloricDish());
        System.out.println("The most caloric dish is: " + findMostCaloricDishUsingComparator());
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Average calories in menu: " + calculateAverageCalories());
        System.out.println("Menu statistics: " + calculateMenuStatistics());
        System.out.println("Short menu: " + getShortMenu());
        System.out.println("Short menu comma separated: " + getShortMenuCommaSeparated());
    }

    private static IntSummaryStatistics calculateMenuStatistics() {
        return Dish.menu.stream().collect(summarizingInt(Dish::getCalories));
    }


    private static Double calculateAverageCalories() {
        return Dish.menu.stream().collect(averagingInt(Dish::getCalories));
    }

    private static int calculateTotalCalories() {
        return Dish.menu.stream().collect(summingInt(Dish::getCalories));
    }

    private static Dish findMostCaloricDishUsingComparator() {
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        return Dish.menu.stream().max(dishComparator).get();
    }

    private static Dish findMostCaloricDish() {
        return Dish.menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)).get();
    }

    private static long howManyDishes() {
        return Dish.menu.stream().collect(counting());
    }

    private static String getShortMenu() {
        return Dish.menu.stream().map(Dish::getName).collect(joining());
    }

    public static String getShortMenuCommaSeparated() {
        return Dish.menu.stream().map(Dish::getName).collect(joining(","));
    }
}
