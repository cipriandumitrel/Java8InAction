package net.java8.part2.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Ciprian on 6/4/2017.
 */

public class ReduceTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum of numbers is " + sum);
        int product = numbers.stream().reduce(1, (a,b) -> a*b);
        System.out.println("Product of numbers is " + product);
        Optional<Integer> minimum = numbers.stream().reduce(Integer::min);
        minimum.ifPresent(min -> System.out.println("Minimum is " + min));
        Optional<Integer> maximum = numbers.stream().reduce(Integer::max);
        maximum.ifPresent(max -> System.out.println("Maximum is " + max));
    }
}
