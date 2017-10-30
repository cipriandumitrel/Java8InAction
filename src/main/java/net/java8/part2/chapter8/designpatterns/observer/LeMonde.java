package net.java8.part2.chapter8.designpatterns.observer;

/**
 * Created by Ciprian on 10/30/2017.
 */
public class LeMonde implements Observer {

    @Override
    public void notify(String tweet) {
        System.out.println("Today cheese, wine and news! " + tweet);
    }
}
