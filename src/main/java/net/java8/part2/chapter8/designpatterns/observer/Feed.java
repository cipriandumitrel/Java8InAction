package net.java8.part2.chapter8.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ciprian on 10/30/2017.
 */
public class Feed implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }
}
