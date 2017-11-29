package net.java8.part3.chapter11;

import static net.java8.part3.chapter11.Util.delay;
import static net.java8.part3.chapter11.Util.format;

/**
 * Created by ciprian on 11/29/17.
 */

public class Discount {
  public enum Code {
    NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

    private final int percentage;

    Code(int percentage) {
      this.percentage = percentage;
    }
  }

  public static String applyDiscount(Quote quote) {
    return quote.getShopName() +  " price is " +
            Discount.apply(quote.getPrice(), quote.getDiscountCode());
  }

  private static double apply(double price, Code discountCode) {
    delay();
    return format(price * (100 - discountCode.percentage) / 100);
  }
}
