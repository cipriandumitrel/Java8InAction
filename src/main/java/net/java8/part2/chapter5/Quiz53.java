package net.java8.part2.chapter5;

import net.java8.part2.Dish;

/**
 * Created by Ciprian on 6/4/2017.
 */
public class Quiz53 {

    public static void main(String[] args) {
        int numberOfDishes = Dish.menu.stream().map(dish -> 1).reduce(0, Integer::sum);
        System.out.println("Number of dishes is " + numberOfDishes);
    }
}
