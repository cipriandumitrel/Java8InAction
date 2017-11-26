package net.java8.part3.chapter11;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Created by ciprian on 11/23/17.
 */

public class Util {

    private static final DecimalFormat formatter =
            new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));

    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static double format(double number) {
        synchronized (formatter) {
            return new Double(formatter.format(number));
        }
    }
}
