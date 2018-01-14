package net.java8.part4.chapter14;

import java.util.function.DoubleUnaryOperator;

public class Currying {

    /**
     * Converts a measurement unit to another one (for example Celsius degrees to Fahrenheit)
     * @param x - quantity of the unit to be converted
     * @param f - conversion factor
     * @param b - baseline
     * @return the value for the unit in which the parameter unit was converted
     */
    static double converter(double x, double f, double b) {
        return x * f + b;
    }

    /**
     * Converts a measurement unit to another one (for example Celsius degrees to Fahrenheit)
     * @param f - conversion factor
     * @param b - baseline
     * @return a DoubleUnaryOperator on which we can call the applyAsDouble method, method to which we can
     * pass as a parameter the quantity of the unit to be converted.
     */
    static DoubleUnaryOperator curriedConverter(double f, double b) {
        return (double x) -> x * f + b;
    }

    public static void main(String[] args) {

        DoubleUnaryOperator convertCtoF = curriedConverter(9.0/5, 32);
        DoubleUnaryOperator convertUSDtoGBP = curriedConverter(0.6, 0);
        DoubleUnaryOperator convertKmtoMi = curriedConverter(0.6214, 0);

        System.out.println(convertCtoF.applyAsDouble(30));
        System.out.println(convertUSDtoGBP.applyAsDouble(30));
        System.out.println(convertKmtoMi.applyAsDouble(30));
    }
}
