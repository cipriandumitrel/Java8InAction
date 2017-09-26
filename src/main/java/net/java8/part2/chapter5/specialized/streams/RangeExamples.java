package net.java8.part2.chapter5.specialized.streams;

import java.util.stream.IntStream;

/**
 * Created by Ciprian on 6/4/2017.
 */

public class RangeExamples {
    public static void main(String[] args) {
        long numberOfEvensInOpenInterval = IntStream.range(0, 100).filter(i -> i%2 == 0).count();
        long numberOfEvensInClosedInterval = IntStream.rangeClosed(0, 100).filter(i -> i%2 == 0).count();

        System.out.print("numberOfEvensInOpenInterval:" + numberOfEvensInOpenInterval + " "
                + "numberOfEvensInClosedInterval:" + numberOfEvensInClosedInterval);
    }
}
