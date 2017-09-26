package net.java8.part2.chapter6;

import net.java8.part2.Dish;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;

/**
 * Created by Ciprian on 6/5/2017.
 */

public class Quiz61 {
    public static void main(String[] args) {
        String shortMenu = Dish.menu.stream().map(Dish::getName).collect(joining());
        System.out.println(shortMenu);

        String shortMenu1 = Dish.menu.stream().map(Dish::getName)
                .collect( reducing( (s1, s2) -> s1 + s2 ) ).get();
        System.out.println(shortMenu1);

        String shortMenu3 = Dish.menu.stream().collect(reducing("", Dish::getName, (s1, s2) -> s1 + s2));
        System.out.println(shortMenu3);
    }
}
