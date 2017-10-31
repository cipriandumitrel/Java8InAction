package net.java8.part3.chapter8.debugging;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ciprian on 10/31/2017.
 * If a method reference refers to a method declared in the same class as where
 * it is used, then it will appear in the stack trace.
 */

public class LambdasDebuggingSameClass {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        numbers.stream().map(LambdasDebuggingSameClass::divideByZero).forEach(System
                .out::println);    
    }

    private static int divideByZero(int n) {
        return n/0;
    }
}
