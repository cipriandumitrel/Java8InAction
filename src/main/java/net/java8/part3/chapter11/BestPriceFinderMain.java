package net.java8.part3.chapter11;

import java.util.List;
import java.util.function.Supplier;

/**
 * Created by Ciprian on 11/27/2017.
 */
public class BestPriceFinderMain {

    private static BestPriceFinder bestPriceFinder = new BestPriceFinder();

    public static void main(String[] args) {

        executeFindPriceOperation("sequential",
                () -> bestPriceFinder.findPricesSequential("myPhone27S"));

        executeFindPriceOperation("parallel",
                () -> bestPriceFinder.findPricesParallel("myPhone27S"));

        executeFindPriceOperation("composed CompletableFuture",
                () -> bestPriceFinder.findPricesWithFutures("myPhone27S"));

    }

    private static void executeFindPriceOperation(String message, Supplier<List<String>> priceSupplier) {
        long start = System.nanoTime();
        System.out.println(priceSupplier.get());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println(message + " done in " + duration + " msecs");
    }
}
