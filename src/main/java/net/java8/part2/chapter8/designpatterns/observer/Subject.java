package net.java8.part2.chapter8.designpatterns.observer;

/**
 * Created by Ciprian on 10/30/2017.
 */

public interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String tweet);
}
