package net.java8.part3.chapter11;

import static net.java8.part3.chapter11.Util.delay;
import static net.java8.part3.chapter11.Util.randomDelay;

/**
 * Created by Ciprian on 12/1/2017.
 */

public class ExchangeService {

    public enum Currency {
        USD(1.0), EUR(1.35387), GBP(1.69715), CAD(.92106), MXN(.07683);

        private double rate;

        Currency(double rate) {
            this.rate = rate;
        }
    }

    public static double getRate(Currency from, Currency to) {
        return getRateWithDelay(from, to);
    }

    private static double getRateWithDelay(Currency from, Currency to) {
        randomDelay();
        return to.rate / from.rate;
    }
}
