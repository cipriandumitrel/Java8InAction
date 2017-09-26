package net.java8.part1.chapter3;

import net.java8.part1.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

/**
 * Created by Ciprian on 2/4/2017.
 */
public class SortingApples {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple("green", 150L), new Apple("red", 10L),
                new Apple("green", 10L), new Apple("blue", 170L));
        inventory.sort(new AppleComparator());

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        inventory.sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));

        inventory.sort(comparing(Apple::getWeight).reversed());

        inventory.sort(comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor));

        Predicate<Apple> redApple = a -> "Red".equals(a.getColor());

        Predicate<Apple> redAndHeavyApple = redApple.and(a -> a.getWeight() > 150);
    }
}
