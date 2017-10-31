package net.java8.part3.chapter8.designpatterns.chainofresponsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Created by Ciprian on 10/30/2017.
 */

public class ChainOfResponsibilityMain {

    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);
        String result = p1.handle("Aren't labdas really sexy?!!");
        System.out.println(result);

        //Using lambda expressions
        UnaryOperator<String> headerProcessing = (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing =  (String text) -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);

        String result1 = pipeline.apply("Aren't labdas really sexy?!!");
        System.out.println(result1);
    }
}
