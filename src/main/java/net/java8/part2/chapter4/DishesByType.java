package net.java8.part2.chapter4;

import net.java8.part2.Dish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by Ciprian on 2/7/2017.
 */

public class DishesByType {
    public static void main(String[] args) {
        Map<Dish.Type, List<Dish>> dishesByType = new HashMap<>();

        for (Dish dish : Dish.menu) {
            if (dishesByType.containsKey(dish.getType())) {
                List<Dish> dishesForType = dishesByType.get(dish.getType());
                if (!dishesForType.contains(dish)) {
                    dishesForType.add(dish);
                }
            }
            else{
                List<Dish> dishesForType = new ArrayList<>();
                dishesForType.add(dish);
                dishesByType.put(dish.getType(), dishesForType);
            }
        }

        System.out.println(dishesByType);

        Map<Dish.Type, List<Dish>> dishesByType1 =
                Dish.menu.stream().collect(groupingBy(Dish::getType));

        System.out.println(dishesByType1);
    }
}
