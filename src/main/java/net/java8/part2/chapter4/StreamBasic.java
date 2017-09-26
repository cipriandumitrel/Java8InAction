package net.java8.part2.chapter4;

import net.java8.part2.Dish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ciprian on 2/7/2017.
 */

public class StreamBasic {

    public static void main(String[] args) {
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

        System.out.println("------------------");

        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);

        System.out.println("------------------");

        getThreeHighCaloricDishNamesInJava8(Dish.menu).forEach(System.out::println);
    }

    private static List<String> getThreeHighCaloricDishNamesInJava8(List<Dish> menu) {
        return menu.stream()
                .filter(d -> {
                    System.out.println("filtering " + d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println("mapping " + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
    }

    private static List<String> getLowCaloricDishesNamesInJava7(List<Dish> menu) {

        List<Dish> lowCaloricDishes = new ArrayList<>();

        for(Dish dish : menu){
            if(dish.getCalories() < 400){
                lowCaloricDishes.add(dish);
            }
        }

        List<String> lowCaloricDishesNames = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        for(Dish dish : lowCaloricDishes){
            lowCaloricDishesNames.add(dish.getName());
        }

        return lowCaloricDishesNames;
    }

    private static List<String> getLowCaloricDishesNamesInJava8(List<Dish> menu) {
        return menu.parallelStream().filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName).collect(Collectors.toList());
    }

}
