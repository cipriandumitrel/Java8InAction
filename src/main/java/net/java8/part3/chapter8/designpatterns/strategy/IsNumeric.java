package net.java8.part3.chapter8.designpatterns.strategy;

/**
 * Created by Ciprian on 10/30/2017.
 */
public class IsNumeric implements ValidationStrategy {

    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
