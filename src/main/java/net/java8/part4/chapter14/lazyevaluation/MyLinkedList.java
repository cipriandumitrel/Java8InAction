package net.java8.part4.chapter14.lazyevaluation;

import java.util.function.Predicate;

public class MyLinkedList<T> implements MyList<T> {
    private final T head;
    private final MyList<T> tail;

    public MyLinkedList(T head, MyList<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public T head() {
        return head;
    }

    @Override
    public MyList<T> tail() {
        return tail;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public MyList<T> filter(Predicate<T> p) {
        return isEmpty() ? this : p.test(head()) ? new MyLinkedList<>(
                head(), tail().filter(p)) : tail().filter(p);
    }
}
