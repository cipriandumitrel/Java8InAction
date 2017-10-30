package net.java8.part2.chapter8.designpatterns.chainofresponsibility;

/**
 * Created by Ciprian on 10/30/2017.
 */
public class HeaderTextProcessing extends ProcessingObject<String> {

    @Override
    protected String handleWork(String input) {
        return "From Raoul, Mario and Alan: " + input;
    }
}
