package net.java8.part1.chapter3;

import net.java8.part1.Apple;

import java.util.Comparator;

/**
 * Created by Ciprian on 2/4/2017.
 */

public class AppleComparator implements Comparator<Apple> {

    @Override
    public int compare(Apple apple1, Apple apple2) {
        return apple1.getWeight().compareTo(apple2.getWeight());
    }
}
