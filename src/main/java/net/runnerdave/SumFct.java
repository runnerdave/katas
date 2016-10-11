package net.runnerdave;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by davidajimenez on 11/10/2016.
 */
public class SumFct {
    private static Map<Long, Long> map = new HashMap<>();

    public static BigInteger perimeter(BigInteger n) {
        int numberOfSquares = n.intValue();
        long value = 0;
        for (long i = 1; i <= numberOfSquares + 1; i++) {
            value = value + fibonacci(i);
        }

        return BigInteger.valueOf(value * 4);
    }

    public static BigInteger fibonacciBigInt(BigInteger n) {
        if (n.intValue() <= 1) return n;
        else return fibonacciBigInt(n.subtract(BigInteger.ONE)).add(fibonacciBigInt(n.subtract(new BigInteger("2"))));
    }

    public static long fibonacci(long n) {
        if (n <= 1) return n;
        else if (map.containsKey(n)) {
            return map.get(n);
        } else {
            long fibo = fibonacci(n - 1) + fibonacci(n - 2);
            map.put(n,fibo);
            return fibo;
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for (int i = 1; i <= n; i++)
            System.out.println(i + ": " + fibonacciBigInt(BigInteger.valueOf(i)));
        ;
    }
}
