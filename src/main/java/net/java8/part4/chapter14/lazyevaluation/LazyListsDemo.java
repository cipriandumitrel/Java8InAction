package net.java8.part4.chapter14.lazyevaluation;

public class LazyListsDemo {

    public static void main(String[] args) {
        MyList<Integer> list = new MyLinkedList<>(5, new MyLinkedList<>(10, new EmptyList<>()));
    }
}
