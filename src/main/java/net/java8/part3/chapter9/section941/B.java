package net.java8.part3.chapter9.section941;

/**
 * Created by Ciprian on 11/2/2017.
 */
public interface B extends A {
    default void hello() {
        System.out.println("Hello from B");
    }
}
