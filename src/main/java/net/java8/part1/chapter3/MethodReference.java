package net.java8.part1.chapter3;

import net.java8.part1.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by Ciprian on 2/4/2017.
 */

public class MethodReference {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "A", "B");
        list.sort((String::compareToIgnoreCase));
        System.out.println(list);

        Apple apple = new Apple();
        //echivalent cu
        Supplier<Apple> appleSupplier = () -> apple;
        Apple apple1 = appleSupplier.get();

        Supplier<Apple> appleSupplier1 = Apple::new;
        Apple apple2 = appleSupplier1.get();

        List<Long> weights = Arrays.asList(7L,3L,4L,10L);
        List<Apple> apples = map(weights, Apple::new);

        TriFunction<Integer, Integer, Integer, Color> triFunction = Color::new;
    }

    private static List<Apple> map(List<Long> weights, Function<Long, Apple> appleLongFunction) {
        List<Apple> resultingApples = new ArrayList<>();

        for(Long weight : weights){
            resultingApples.add(appleLongFunction.apply(weight));
        }

        return resultingApples;
    }
}
