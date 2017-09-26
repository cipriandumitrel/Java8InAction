package net.java8.part2.chapter5;

import net.java8.part2.Dish;

import java.util.Optional;

/**
 * Created by Ciprian on 5/28/2017.
 */
public class FindingAndMatching {
    public static void main(String[] args) {
        boolean menuIsSlightlyVegetarian = Dish.menu.stream().anyMatch(Dish::isVegetarian);
        if(menuIsSlightlyVegetarian){
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        boolean isHealthy = Dish.menu.stream()
                .noneMatch(d -> d.getCalories() >= 1000);

        if(isHealthy){
            System.out.println("The menu is healthy!");
        }

        Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println(d.getName()));

    }
}
