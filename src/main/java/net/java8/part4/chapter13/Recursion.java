package net.java8.part4.chapter13;

import java.util.stream.LongStream;

public class Recursion {

    public static void main(String[] args) {
        System.out.println(factorialIterative(5));
        System.out.println(factorialRecursive(5));
        System.out.println(factorialStreams(5));
        System.out.println(factorialTailRecursive(5));
    }

    private static long factorialTailRecursive(long n) {
        return factorialHelper(1, n);
    }

    private static long factorialHelper(long i, long n) {
        return n == 1 ? i: factorialHelper(i * n, n-1);
    }

    private static long factorialStreams(long n) {
        return LongStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
    }

    private static long factorialRecursive(long n) {
        return (n == 1) ? 1 : n * factorialRecursive(n - 1);
    }

    private static long factorialIterative(long n) {
        long result = 1;

        for(int i = 1; i <= n; i++) {
            result = result * i;
        }

        return result;
    }
}
