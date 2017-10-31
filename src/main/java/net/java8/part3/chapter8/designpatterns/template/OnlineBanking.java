package net.java8.part3.chapter8.designpatterns.template;

/**
 * Created by Ciprian on 10/30/2017.
 */

public abstract class OnlineBanking {

    public void processCustomer(int id) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }

    abstract void makeCustomerHappy(Customer c);

    // dummy Customer class
    static private class Customer {
    }

    // dummy Database class
    static private class Database {
        static Customer getCustomerWithId(int id) {
            return new Customer();
        }
    }
}


