package net.java8.part3.chapter11;

import java.util.concurrent.Future;

/**
 * Created by Ciprian on 11/26/2017.
 */

public class ShopClient {

    private static final String PRODUCT_NAME = "a well known product";

    public static void main(String[] args) {
        Shop shop = new Shop("ABigShop");

        /* Synchronous call */
        /*long start = System.nanoTime();
        double price = shop.getPrice(PRODUCT_NAME);
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned the after " + invocationTime + " msecs");
        System.out.printf("Price is %.2f%n ", price);*/

        /* Asynchronous call */
        long asyncCallStart = System.nanoTime();
        Future<Double> priceFuture = shop.getPriceAsyncRewritten(PRODUCT_NAME);
        long invocationTimeWithAsyncCall = ((System.nanoTime() - asyncCallStart) / 1_000_000);
        System.out.println("Async invocation returned the after " + invocationTimeWithAsyncCall + " msecs");

        try {
            double retrievedPrice = priceFuture.get();
            System.out.printf("Price is %.2f%n ", retrievedPrice);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long retrievalTime = ((System.nanoTime() - asyncCallStart) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }
}
