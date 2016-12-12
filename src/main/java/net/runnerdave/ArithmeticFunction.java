package net.runnerdave;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;

/**
 * Created by David A. Jiménez (e67997) on 12/12/2016.
 */
public class ArithmeticFunction {
    /**
     * Given two numbers and an arithmetic operator (the name of it, as a string), return the result of the two numbers
     * having that operator used on them.
     * a and b will both be positive integers, and a will always be the first number in the operation, and b always the second.
     *
     * The four operators are "add", "subtract", "divide", "multiply".
     *
     * A few examples:
     * arithmetic(5, 2, "add") should return 7
     * arithmetic(5, 2, "subtract") should return 3
     * arithmetic(5, 2, "multiply") should return 10
     * arithmetic(5, 2, "divide") should return 2.5
     *
     * Try to do it without using if statements!
     * @param a
     * @param b
     * @param operator
     * @return
     */
    public static double arithmetic(int a, int b, String operator) {
        Operation op = new Add();
        switch (operator) {
            case "subtract":
                op = new Subtract();
                break;
            case "divide":
                op = new Divide();
                break;
            case "multiply":
                op = new Multiply();
                break;
        }
        return op.operate(a,b);
    }

    static Map<String, BinaryOperator<Integer>> myMap = new HashMap<>();

    static {
        myMap.put("add", (u,t)->u+t);
        myMap.put("subtract", (u,t)->u-t);
        myMap.put("multiply", (u,t)->u*t);
        myMap.put("divide", (u,t)->u/t);
    }

    public static int arithmeticMyCool(int a, int b, String operator) {
        return arithmeticMyCool(a, b, myMap.get(operator));
    }

    private static Integer arithmeticMyCool(int a, int b, BinaryOperator<Integer> function) {
        return function.apply(a,b);
    }


    static Map<String, BinaryOperator<Integer>> operators = new HashMap<>();

    static {
        operators.put("add", (a, b) -> a + b);
        operators.put("subtract", (a, b) -> a - b);
        operators.put("multiply", (a, b) -> a * b);
        operators.put("divide", (a, b) -> a / b);
    }

    public static int arithmeticCool(int a, int b, String operator) {
        return arithmeticCool(a, b, operators.get(operator));
    }

    private static Integer arithmeticCool(int a, int b, BinaryOperator<Integer> operator) {
        return Optional.ofNullable(operator).orElse((x, y) -> 0).apply(a, b);
    }

}

interface Operation {
    public double operate(int o1, int o2);
}

class Add implements Operation{

    @Override
    public double operate(int o1, int o2) {
        return o1+o2;
    }
}

class Subtract implements Operation{

    @Override
    public double operate(int o1, int o2) {
        return o1-o2;
    }
}

class Multiply implements Operation{

    @Override
    public double operate(int o1, int o2) {
        return o1*o2;
    }
}

class Divide implements Operation{

    @Override
    public double operate(int o1, int o2) {
        return o1/o2;
    }
}
