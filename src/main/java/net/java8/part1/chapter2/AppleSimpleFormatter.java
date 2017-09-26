package net.java8.part1.chapter2;

import net.java8.part1.Apple;

/**
 * Created by Ciprian on 1/25/2017.
 */

public class AppleSimpleFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}
