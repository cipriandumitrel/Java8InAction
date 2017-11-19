package net.java8.part3.chapter10;

import java.util.Optional;

/**
 * Created by Ciprian on 11/17/2017.
 */

public class Person {

    private Optional<Car> car;

    private int age;

    public int getAge() {
        return age;
    }

    public Optional<Car> getCar() {
        return car;
    }
}
