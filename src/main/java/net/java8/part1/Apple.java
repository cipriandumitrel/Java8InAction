package net.java8.part1;

/**
 * Created by Ciprian on 11/21/2016.
 */

public class Apple {

    private Long weight;
    private String color;

    public Apple() {
    }

    public Apple(Long weight) {
        this.weight = weight;
    }

    public Apple(String color, Long weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public Long getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
