package net.java8.part1.chapter2;

import net.java8.part1.Apple;

/**
 * Created by Ciprian on 1/25/2017.
 */

public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
