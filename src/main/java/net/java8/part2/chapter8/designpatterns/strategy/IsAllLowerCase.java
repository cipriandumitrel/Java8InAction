package net.java8.part2.chapter8.designpatterns.strategy;

/**
 * Created by Ciprian on 10/30/2017.
 */

public class IsAllLowerCase implements ValidationStrategy {

    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}
