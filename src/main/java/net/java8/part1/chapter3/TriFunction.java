package net.java8.part1.chapter3;

/**
 * Created by Ciprian on 2/4/2017.
 */

public interface TriFunction<T,U,V,R> {
    R apply(T t, U u, V v);
}
