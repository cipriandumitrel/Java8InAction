package net.java8.part4.chapter14.lazyevaluation;

import java.util.function.Predicate;

public interface MyList<T> {

    T head();

    MyList<T> tail();

    default boolean isEmpty() {
        return true;
    }

    MyList<T> filter(Predicate<T> p);
}
