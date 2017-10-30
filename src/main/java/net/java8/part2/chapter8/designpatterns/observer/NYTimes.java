package net.java8.part2.chapter8.designpatterns.observer;

/**
 * Created by Ciprian on 10/30/2017.
 */
public class NYTimes implements Observer {

    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("money")) {
            System.out.println("Breaking news in NY! " + tweet);
        }
    }
}
