package net.java8.part1.chapter3;

import java.util.function.Function;

/**
 * Created by Ciprian on 2/5/2017.
 */

public class FunctionTest {
    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;

        Function<Integer, Integer> h = f.andThen(g); //g(f(x))
        Function<Integer, Integer> i = f.compose(g); // f(g(x))

        System.out.println(h.apply(1));
        System.out.println(i.apply(1));

    }
}
