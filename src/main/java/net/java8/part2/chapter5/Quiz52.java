package net.java8.part2.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ciprian on 5/28/2017.
 */
public class Quiz52 {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);

        integerList
                .stream()
                .map(integer -> integer * integer)
                .collect(Collectors.toList())
                .forEach(integer -> System.out.print(integer + " "));

        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(3,4);

        List<int []> pairs = list1
                .stream()
                .flatMap(i -> list2
                        .stream()
                        .filter(j -> (i+j)%3 == 0)
                        .map(j -> new int[]{i,j}))
                .collect(Collectors.toList());
    }
}
