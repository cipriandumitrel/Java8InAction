package net.java8.part2.chapter5;

import net.java8.part2.Dish;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ciprian on 5/17/2017.
 */

public class FirstTwoMeatDishes {

    public static void main(String[] args) {
        List<Dish> first2MeatDishes = Dish.menu.stream()
                                               .filter(d -> d.getType() == Dish.Type.MEAT)
                                               .limit(2)
                                               .collect(Collectors.toList());
        first2MeatDishes.forEach(System.out::println);
    }
}
