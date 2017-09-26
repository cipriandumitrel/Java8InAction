package net.java8.part1.chapter2;

import net.java8.part1.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Ciprian on 1/25/2017.
 */

public class FilteringApples {

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate){
        List<Apple> filteredApples = new ArrayList<>();

        for(Apple apple : inventory){
            if(predicate.test(apple)){
                filteredApples.add(apple);
            }
        }

        return filteredApples;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e: list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter){
        for(Apple apple: inventory) {
            System.out.println(formatter.accept(apple));
        }
    }

    public static void main(String[] args) {
        List<Apple> greenApples = filterApples(Arrays.asList(new Apple("green", 150L), new Apple("red", 10L),
                new Apple("green", 10L), new Apple("blue", 170L)), apple -> "green".equals(apple.getColor()));

        for(Apple greenApple : greenApples){
            System.out.println("Green apple: " +  greenApple.toString());
        }

        List<Apple> heavyApples = filterApples(Arrays.asList(new Apple("green", 150L), new Apple("red", 10L),
                new Apple("green", 10L), new Apple("blue", 170L)), new AppleHeavyApplesPredicate());

        for(Apple heavyApple : heavyApples){
            System.out.println("Heavy apple: " +  heavyApple.toString());
        }

        prettyPrintApple(Arrays.asList(new Apple("green", 150L), new Apple("red", 10L),
                new Apple("green", 10L), new Apple("blue", 170L)), new AppleFancyFormatter());

        prettyPrintApple(Arrays.asList(new Apple("green", 150L), new Apple("red", 10L),
                new Apple("green", 10L), new Apple("blue", 170L)), new AppleSimpleFormatter());

    }
}
