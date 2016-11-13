package net.runnerdave;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * Created by David A. Jimene (e67997) on 11/11/2016.
 */
public class TriangularTreasure {
    public static int triangular(int n) {
        return n == 1 ? n : n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(laidAsTriangle(5));
    }

    public static int triangularFunctional(int n) {
        return IntStream.range(1, n + 1).peek(System.out::println).sum();
    }

    public static double reverseTriangular(int y) {
        return solveQuadratic(y);
    }

    public static String laidAsTriangle(int side) {
        String str = "";
        for (int i = side; i >= 0; i--) {
            for (int j = i; j > 0; j--) {
                str += "*";
            }
            str += "\n";
        }
        return str;
    }

    public static double solveQuadratic(int y) {
        final int a = 1;
        final int b = 1;
        final int c = -2;

        double temp1 = Math.sqrt(b * b - 4 * a * c * y);

        double root1 = (-b + temp1) / (2 * a);

        return root1;
    }


}
