package net.java8.part4.chapter14.persistentdatastructures;

public class TrainJourney {

    public int price;
    public TrainJourney onward;

    public TrainJourney(int p, TrainJourney t) {
        price = p;
        onward = t;
    }
}
