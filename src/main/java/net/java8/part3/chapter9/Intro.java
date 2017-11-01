package net.java8.part3.chapter9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Ciprian on 11/1/2017.
 */

public class Intro {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,5,1,2,6);

        //sort is the default method of List interface
        //naturalOrder is a static method in Comparator interface
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
    }
}
