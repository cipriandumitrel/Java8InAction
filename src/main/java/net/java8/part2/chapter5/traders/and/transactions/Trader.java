package net.java8.part2.chapter5.traders.and.transactions;

/**
 * Created by Ciprian on 6/4/2017.
 */

public class Trader {

    private final String name;
    private final String city;

    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}
