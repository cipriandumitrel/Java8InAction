package net.java8.part1.chapter2;

import net.java8.part1.Apple;

/**
 * Created by Ciprian on 1/25/2017.
 */

public class AppleHeavyApplesPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 100;
    }
}
