package net.java8.part4.chapter14.patternmatching;

public class Number extends Expr {

    int val;
    public Number(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}
