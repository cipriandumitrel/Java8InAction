package net.java8.part3.chapter11;

import java.util.concurrent.*;

/**
 * Created by ciprian on 11/22/17.
 */
public class SimpleFutures {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Double> future = executorService.submit(() -> doSomeLongComputation());

        doSomethingElse();

        try {
            Double result = future.get(5, TimeUnit.SECONDS);
            System.out.println("Result is " + result);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

    }

    private static void doSomethingElse() {
        System.out.println("Something else");
    }

    private static Double doSomeLongComputation() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 200d;
    }

}
