package net.java8.part3.chapter9.section943;

/**
 * Created by Ciprian on 11/2/2017.
 */
public interface B {
    default void hello() {
        System.out.println("Hello from B");
    }
}
