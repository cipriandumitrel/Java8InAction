package net.java8.part1.chapter2;

import net.java8.part1.Apple;

/**
 * Created by Ciprian on 1/25/2017.
 */

public class AppleFancyFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" :
                "light";
        return "A " + characteristic +
                " " + apple.getColor() +" apple";
    }
}
