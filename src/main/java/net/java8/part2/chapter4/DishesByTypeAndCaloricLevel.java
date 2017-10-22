package net.java8.part2.chapter4;

import net.java8.part2.Dish;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by Ciprian on 10/22/2017.
 */

public class DishesByTypeAndCaloricLevel {
    public static void main(String[] args) {
        Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                Dish.menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                                    else return Dish.CaloricLevel.FAT;
                                } )
                        )
                );

        System.out.println(dishesByTypeCaloricLevel);
    }
}
