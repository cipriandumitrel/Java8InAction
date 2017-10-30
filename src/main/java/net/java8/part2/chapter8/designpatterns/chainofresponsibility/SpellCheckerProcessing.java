package net.java8.part2.chapter8.designpatterns.chainofresponsibility;

/**
 * Created by Ciprian on 10/30/2017.
 */
public class SpellCheckerProcessing extends ProcessingObject<String> {

    @Override
    protected String handleWork(String input) {
        return input.replaceAll("labda", "lambda");
    }
}
