package net.java8.part3.chapter9.section943;

/**
 * Created by Ciprian on 11/2/2017.
 */
public class C implements B, A {

    public void hello() {
        A.super.hello();
    }

    public static void main(String[] args) {
        new C().hello();
    }
}
