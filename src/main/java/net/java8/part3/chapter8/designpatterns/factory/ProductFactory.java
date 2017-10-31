package net.java8.part3.chapter8.designpatterns.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Created by Ciprian on 10/30/2017.
 */

public class ProductFactory {

    final static private Map<String, Supplier<Product>> map = new HashMap<>();
    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static Product createProduct(String name) {
        switch (name) {
            case "loan" : return new Loan();
            case "stock" : return new Stock();
            case "bond" : return new Bond();
            default: throw new RuntimeException("No such product " + name);
        }
    }

    public static Product createProductLambda(String name) {
        Supplier<Product> productSupplier = map.get(name);
        if(productSupplier != null) return productSupplier.get();
        throw new RuntimeException("No such product " + name);
    }
}
