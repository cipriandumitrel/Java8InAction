package net.java8.part2.chapter5;

import java.util.stream.Stream;

/**
 * Created by Ciprian on 6/4/2017.
 */
public class Quiz54 {

    public static void main(String[] args) {
        Stream.iterate(new int[]{0,1},  n -> new int[]{n[1], n[0] + n[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
    }
}
