package net.java8.part4.chapter14.persistentdatastructures;

import java.util.function.Consumer;

public class PersistentTrainJourney {

    public static void main(String[] args) {
        TrainJourney tj1 = new TrainJourney(40, new TrainJourney(30, null));
        TrainJourney tj2 = new TrainJourney(20, new TrainJourney(50, null));

        TrainJourney appended = append(tj1, tj2);
        visit(appended, tj -> { System.out.print(tj.price + " - "); });
        System.out.println();

        // A new TrainJourney is created without altering tj1 and tj2.
        TrainJourney appended2 = append(tj1, tj2);
        visit(appended2, tj -> { System.out.print(tj.price + " - "); });
        System.out.println();

        TrainJourney linked = link(tj1, tj2);
        visit(linked, (TrainJourney tj) -> System.out.println(tj.price));
    }

    private static void visit(TrainJourney journey, Consumer<TrainJourney> tjConsumer) {
        if(journey != null) {
            tjConsumer.accept(journey);
            visit(journey.onward, tjConsumer);
        }
    }

    private static TrainJourney link(TrainJourney a, TrainJourney b) {
        if(a == null) return b;
        TrainJourney t = a;
        while(t.onward != null){
            t = t.onward;
        }

        t.onward = b;
        return a;
    }

    private static TrainJourney append(TrainJourney a, TrainJourney b) {
        return (a == null) ? b : new TrainJourney(a.price, append(a.onward, b));
    }
}
