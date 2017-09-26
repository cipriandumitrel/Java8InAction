package net.java8.part2.chapter5.traders.and.transactions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by Ciprian on 6/4/2017.
 */

public class TradersAndTransactionsExercise {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //Q1 - Find all transactions in the year 2011 and sort them by value (small to high).
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //Q2 - What are all the unique cities where the traders work?
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList())
                .forEach(System.out::println);

        //Q3 - Find all traders from Cambridge and sort them by name.
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        //Q4 - Return a string of all traders’ names sorted alphabetically.
        String concatenatedString = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct().sorted()
                .reduce("", (t1, t2) -> t1 + t2 );
        System.out.println("Concatenated string is " + concatenatedString);

        //Q5 - Are there any traders based in Milan?
        boolean anyTradersInMilan =
                transactions.stream().anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));
        System.out.println("Are there any traders in Milan? " + (anyTradersInMilan ? "Yes" : "No"));

        //Q6 - Print all transactions’ values from the traders living in Cambridge.
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .forEach(t -> System.out.println(t.getValue()));

        //Q7 - What’s the highest value of all the transactions?
        Optional<Integer> highestTransactionValueOptional = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        highestTransactionValueOptional.ifPresent(maximum -> System.out.println("Maximum value is " + maximum));

        //Q8 - Find the transaction with the smallest value
        Optional<Transaction> smallestTransaction = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));

    }
}
