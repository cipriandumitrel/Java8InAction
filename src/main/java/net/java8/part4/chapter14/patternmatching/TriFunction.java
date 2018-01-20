package net.java8.part4.chapter14.patternmatching;

public interface TriFunction<S, T, U, R> {
    R apply(S s, T t, U u);
}
