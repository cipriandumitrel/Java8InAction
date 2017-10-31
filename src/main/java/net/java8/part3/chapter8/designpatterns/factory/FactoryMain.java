package net.java8.part3.chapter8.designpatterns.factory;

import java.util.function.Supplier;

/**
 * Created by Ciprian on 10/30/2017.
 */
public class FactoryMain {

    public static void main(String[] args) {
        Product p1 = ProductFactory.createProduct("loan");

        Supplier<Product> loanSupplier = Loan::new;
        Product p2 = loanSupplier.get();

        Product p3 = ProductFactory.createProductLambda("loan");
    }
}
