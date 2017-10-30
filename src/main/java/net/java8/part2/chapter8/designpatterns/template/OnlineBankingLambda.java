package net.java8.part2.chapter8.designpatterns.template;

import java.util.function.Consumer;

/**
 * Created by Ciprian on 10/30/2017.
 */
public class OnlineBankingLambda {

    public static void main(String[] args) {
        OnlineBankingLambda onlineBankingLambda = new OnlineBankingLambda();
        onlineBankingLambda.processCustomer(1337, customer -> System.out.println("Evrika!"));
    }

    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer customer = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(customer);
    }

    // dummy Customer class
    static private class Customer {}

    //dummy Database class
    static private class Database {
        static Customer getCustomerWithId(int id){ return new Customer();}
    }
}
