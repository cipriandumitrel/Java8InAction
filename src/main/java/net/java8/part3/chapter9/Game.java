package net.java8.part3.chapter9;

import java.util.Arrays;

/**
 * Created by Ciprian on 11/1/2017.
 */

public class Game {
    public static void main(String[] args) {
        Utils.paint(Arrays.asList(new Square(), new Rectangle(), new Ellipse()));

        Monster m = new Monster();
        m.rotateBy(180);
        m.moveVertically(10);
    }
}
