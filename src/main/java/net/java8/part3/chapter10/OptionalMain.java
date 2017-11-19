package net.java8.part3.chapter10;

import java.util.Optional;

/**
 * Created by Ciprian on 11/17/2017.
 */

public class OptionalMain {

    public String getCarInsuranceName(Optional<Person> personOptional) {

        return personOptional.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    /** Beginning of Quiz10.2 solution **/
    public String getCarInsuranceName(Optional<Person> personOptional, int minAge) {
        return personOptional.filter(p -> p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
    /** End of Quiz10.2 solution **/

    /** Beginning of Quiz10.1 solution **/
    public Insurance findCheapestInsurance(Person person, Car car) {
        return new Insurance();
    }

    public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }
    /** End of Quiz10.1 solution **/

    public static void main(String[] args) {
        System.out.println(new OptionalMain().getCarInsuranceName(Optional.empty()));
    }
}
