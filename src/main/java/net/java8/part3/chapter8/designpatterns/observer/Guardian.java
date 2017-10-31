package net.java8.part3.chapter8.designpatterns.observer;

/**
 * Created by Ciprian on 10/30/2017.
 */

public class Guardian implements Observer {

    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("queen")) {
            System.out.println("Yet another news in London... " + tweet);
        }
    }
}
