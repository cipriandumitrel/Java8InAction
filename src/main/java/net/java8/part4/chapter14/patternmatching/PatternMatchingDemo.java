package net.java8.part4.chapter14.patternmatching;

import java.util.function.Function;
import java.util.function.Supplier;

public class PatternMatchingDemo {

    static <T> T myIf(boolean b, Supplier<T> trueCase, Supplier<T> falseCase) {
        return b ? trueCase.get() : falseCase.get();
    }

    static <T> T patternMatchingExpr(Expr e, TriFunction<String, Expr, Expr, T> binOpCase,
                                     Function<Integer, T> numCase, Supplier<T> defaultCase) {

        if (e instanceof BinOp) {
            return binOpCase.apply(((BinOp) e).opname, ((BinOp) e).left, ((BinOp) e).right);
        } else if (e instanceof Number) {
            return numCase.apply(((Number) e).val);
        } else {
            return defaultCase.get();
        }
    }

    public static Expr simplify(Expr e) {
        TriFunction<String, Expr, Expr, Expr> binOpCase =
                (opName, left, right) -> {
                    if ("+".equals(opName)) {
                        if (left instanceof Number && ((Number) left).val == 0) {
                            return right;
                        }
                        if (right instanceof Number && ((Number) right).val == 0) {
                            return left;
                        }
                    }
                    if ("*".equals(opName)) {
                        if (left instanceof Number && ((Number) left).val == 1) {
                            return right;
                        }
                        if (right instanceof Number && ((Number) right).val == 1) {
                            return left;
                        }
                    }
                    return new BinOp(opName, left, right);
                };
        Function<Integer, Expr> numCase = val -> new Number(val);

        Supplier<Expr> defaultCase = () -> new Number(0);

        return patternMatchingExpr(e, binOpCase, numCase, defaultCase);
    }

    public static void main(String[] args) {
        Expr e = new BinOp("+", new Number(5), new Number(0));
        Expr match = simplify(e);
        System.out.println(match);
    }
}
