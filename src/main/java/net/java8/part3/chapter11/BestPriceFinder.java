package net.java8.part3.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by Ciprian on 11/27/2017.
 */

public class BestPriceFinder {

    private static final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("ShopEasy"));

    private final Executor executor = Executors.newFixedThreadPool(shops.size(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    });

    public List<String> findPricesSequential(String product) {
        return shops.stream()
                .map(shop -> shop.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(toList());
    }

    public List<String> findPricesParallel(String product) {
        return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)))
                .collect(toList());
    }

    public List<String> findPricesWithFutures(String product) {
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                        .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
                        .map(future -> future.thenApply(Quote::parse))
                        .map(future -> future.thenCompose(quote ->
                                CompletableFuture.supplyAsync(
                                        () -> Discount.applyDiscount(quote), executor)))
                        .collect(toList());

        return priceFutures.stream().map(CompletableFuture::join).collect(toList());
    }

    public List<String> findPricesInUSD(String product) {

        List<CompletableFuture<Double>> priceFutures = new ArrayList<>();
        for (Shop shop : shops) {
            CompletableFuture<Double> futurePriceInUSD =
                    CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                            .thenCombine(
                                    CompletableFuture.supplyAsync(
                                            () -> ExchangeService.getRate(ExchangeService.Currency.EUR,
                                                    ExchangeService.Currency.USD)),
                                    (price, rate) -> Double.valueOf(price) * rate
                            );
            priceFutures.add(futurePriceInUSD);
        }

        List<String> prices = priceFutures
                .stream()
                .map(CompletableFuture::join)
                .map(price -> " price is " + price)
                .collect(Collectors.toList());
        return prices;
    }

    public List<String> findPricesInUSDJava7(String product) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Future<Double>> priceFutures = new ArrayList<>();

        for (Shop shop : shops) {
            final Future<Double> futureRate =
                    executorService.submit(() ->
                            ExchangeService.getRate(ExchangeService.Currency.EUR, ExchangeService.Currency.USD));

            Future<Double> futurePriceInUSD = executorService.submit(() -> {
                try {
                    double priceInEUR = Double.valueOf(shop.getPrice(product));
                    return priceInEUR * futureRate.get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
            });

            priceFutures.add(futurePriceInUSD);
        }

        List<String> prices = new ArrayList<>();
        for (Future<Double> priceFuture : priceFutures) {
            try {
                prices.add(" price is " + priceFuture.get());
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        return prices;
    }
}
