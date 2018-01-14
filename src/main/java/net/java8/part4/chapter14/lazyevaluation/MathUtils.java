package net.java8.part4.chapter14.lazyevaluation;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MathUtils {

    public static void main(String[] args) {
        primes(10).forEach(n -> System.out.print(n + " "));
    }

    private static Stream<Integer> primes(int n) {
        return Stream.iterate(2, i ->  i + 1)
                .filter(MathUtils::isPrime)
                .limit(n);
    }

    private static boolean isPrime(int number) {
        int candidateRoot = (int) Math.sqrt(number);
        return IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> number %i == 0 );
    }
}
