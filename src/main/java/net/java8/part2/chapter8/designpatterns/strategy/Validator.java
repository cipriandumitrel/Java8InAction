package net.java8.part2.chapter8.designpatterns.strategy;

/**
 * Created by Ciprian on 10/30/2017.
 */

public class Validator {
    private ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }
}
