package net.java8.part3.chapter8.debugging;

import net.java8.part3.chapter8.testing.Point;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ciprian on 10/31/2017.
 */

public class LambdasDebugging {

    public static void main(String[] args) {
        List<Point> points = Arrays.asList(new Point(12, 2), null);
        points.stream().map(p -> p.getX()).forEach(System.out::println);
    }
}
