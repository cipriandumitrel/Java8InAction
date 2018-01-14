package net.java8.part4.chapter14.lazyevaluation;

public interface MyList<T> {

    T head();

    MyList<T> tail();

    default boolean isEmpty() {
        return true;
    }
}
