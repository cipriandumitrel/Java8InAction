package net.java8.part3.chapter8.designpatterns.strategy;

/**
 * Created by Ciprian Dumitrel on 10/30/2017.
 * In Strategy pattern, a class behavior or its algorithm can be changed at run time.
 * This type of design pattern comes under behavior pattern.
 * In Strategy pattern, objects which represent various strategies and a context object whose behavior varies as
 * per its strategy object are created.
 * The strategy object changes the executing algorithm of the context object.
 */
public class ValidatorDemo {

    public static void main(String[] args) {
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("aaaa");
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = lowerCaseValidator.validate("bbbbb");

        System.out.println("b1: " + b1);
        System.out.println("b2: " + b2);

        boolean numericValidatorLambda = new Validator(s -> s.matches("\\d+")).validate("aaaaa");
        boolean lowerCaseValidatorLambda = new Validator(s -> s.matches("[a-z]+")).validate("bbbb");

        System.out.println("numericValidatorLambda: " + numericValidatorLambda);
        System.out.println("lowerCaseValidatorLambda: " + lowerCaseValidatorLambda);
    }
}
