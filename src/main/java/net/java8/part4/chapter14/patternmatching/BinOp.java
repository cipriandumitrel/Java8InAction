package net.java8.part4.chapter14.patternmatching;

public class BinOp extends Expr {

    String opname;
    Expr left, right;

    public BinOp(String opname, Expr left, Expr right) {
        this.opname = opname;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + left + " " + opname + " " + right + ")";
    }
}
