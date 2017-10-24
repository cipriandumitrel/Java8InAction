package net.java8.part2.chapter7;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by Ciprian on 10/24/2017.
 */

public class ParallelStreams {

    //Iterative sum Java7 style
    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }

    //Sequential sum using iterate
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(Long::sum).get();
    }

    //Parallel stream using iterate
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(Long::sum).get();
    }

    //Sequential sum using range
    public static long rangeSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(0, Long::sum);
    }

    //Parallel sum using range
    public static long parallelRangeSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(0, Long::sum);
    }

    public static long measureSumPerformance(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    public static class Accumulator {
        private long total = 0;

        public void add(long value) {
            total += value;
        }
    }

    public static void main(String[] args) {
        System.out.println("Iterative sum is " + iterativeSum(100));
        System.out.println("Sequential sum is " + sequentialSum(100));
        System.out.println("Parallel sum is " + parallelSum(100));
        System.out.println("Sequential range sum is " + rangeSum(100));

        System.out.println("Side effect sum is " + sideEffectSum(100));

        System.out.println("Sequential sum done in: " +
                measureSumPerformance(ParallelStreams::sequentialSum, 10_000_000) + " msecs");

        System.out.println("Iterative sum done in: " +
                measureSumPerformance(ParallelStreams::iterativeSum, 10_000_000) + " msecs");

        System.out.println("Parallel sum done in: " +
                measureSumPerformance(ParallelStreams::parallelSum, 10_000_000) + " msecs");

        System.out.println("Sequential range sum done in: " +
                measureSumPerformance(ParallelStreams::rangeSum, 10_000_000) + " msecs");

        System.out.println("Parallel range sum done in: " +
                measureSumPerformance(ParallelStreams::parallelRangeSum, 10_000_000) + " msecs");

        System.out.println("Side effect sum done in: " +
                measureSumPerformance(ParallelStreams::sideEffectSum, 10_000_000) + " msecs");

        System.out.println("Side effect parallel sum done in: " +
                measureSumPerformance(ParallelStreams::sideEffectParallelSum, 10_000_000) + " msecs");
    }
}
