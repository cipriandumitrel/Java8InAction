package net.java8.part1.chapter3;

import java.util.function.Function;

/**
 * Created by Ciprian on 2/5/2017.
 */
public class LetterTest {

    public static void main(String[] args) {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);
        System.out.println(transformationPipeline.apply(""));
    }
}
