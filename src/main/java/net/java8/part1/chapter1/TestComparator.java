package net.java8.part1.chapter1;

import net.java8.part1.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Ciprian on 11/21/2016.
 */

public class TestComparator {

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate){
        List<Apple> applesAfterFiltering = new ArrayList<>();

        for(Apple apple : inventory){
            if(predicate.test(apple)){
                applesAfterFiltering.add(apple);
            }
        }

        return applesAfterFiltering;
    }

    public static void main(String[] args) {
        Apple apple1 = new Apple("Red", 20L);
        Apple apple2 = new Apple("Green", 23L);
        Apple apple3 = new Apple("Green", 10L);

        ArrayList<Apple> apples = new ArrayList<>(3);

        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);

        apples.sort(Comparator.comparing(Apple::getWeight));

        System.out.println("Apples: ");

        for (Apple apple : apples) {
            System.out.print(apple + " ");
        }

        System.out.println("\nBegin filtering by color");
        List<Apple> applesAfterFiltering = filterApples(apples, (Apple a) -> "Green".equals(a.getColor()));
        System.out.println("\nAfter filtering apples: ");

        for (Apple apple : applesAfterFiltering) {
            System.out.print(apple + " ");
        }

        List<Apple> applesAfterFilteringByColor = apples.stream().filter((Apple a) -> "Green".equals(a.getColor()))
                .collect(Collectors.toList());

        System.out.println("\nAfter filtering apples by color: ");

        for (Apple apple : applesAfterFilteringByColor) {
            System.out.print(apple + " ");
        }

        System.out.println("\nBegin filtering by weight");
        List<Apple> applesAfterFilteringByWeight= filterApples(apples, (Apple a) -> a.getWeight() > 20);
        System.out.println("After filtering apples: ");

        for (Apple apple : applesAfterFilteringByWeight) {
            System.out.print(apple + " ");
        }

        List<Apple> heavyApples = apples.parallelStream().filter((Apple a) -> a.getWeight() > 20)
                .collect(Collectors.toList());

        for(Apple heavyApple : heavyApples){
            System.out.println("Heavy apple: " + heavyApple.toString());
        }
    }
}
