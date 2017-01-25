package net.runnerdave.algorithms.sedgwick.wayne.ch_1_fundamentals.ch_1_1_basic.programming.model;

import net.runnerdave.algorithms.sedgwick.wayne.StdOut;
import net.runnerdave.algorithms.sedgwick.wayne.StdRandom;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by David A. Jiménez (e67997) on 24/01/2017.
 */
public class Ex_1_1_from_1_to_15 {
    public static void main(String[] args) {
        //1.1.1:
        System.out.println("==1.1.1==");
        System.out.println((0 + 15) / 2);
        System.out.println(2.0e-6 * 100000000.1);
        System.out.println(true && false || true && true);

        //1.1.2:
        System.out.println("==1.1.2==");
        System.out.println((1 + 2.236) / 2);
        System.out.println(1 + 2 + 3 + 4.0);
        System.out.println(4.1 >= 4);
        System.out.println(1 + 2 + "3");

        //1.1.3:
        System.out.println("==1.1.3==");
        if (args.length == 3) {
            if (Integer.valueOf(args[0]).equals(Integer.valueOf(args[1])) && Integer.valueOf(args[2]).equals(Integer.valueOf(args[1]))) {
                System.out.println("equal");
            } else {
                System.out.println("not equal");
            }
        }

        //1.1.4
        System.out.println("==1.1.4==");
        int a = 1;
        int b = 2;
        int c = 1;
        //if (a > b) then c = 0; // java does not use then

        //if a > b { c = 0; }// does not compile, fixed in next line
        //if (a > b) { c = 0; } //fix to previous line

        if (a > b) c = 0; // all good!!

        //if (a > b) c = 0 else b = 0;//needs brackets, fixed in the next line
        //if (a > b) {c = 0;} else b = 0; //fix to previous line

        //1.1.5
        System.out.println("==1.1.5==");
        System.out.println(strictlyBetweenOneAndZero(0.1, 0.2));
        System.out.println(strictlyBetweenOneAndZero(1.1, 0.2));
        System.out.println(strictlyBetweenOneAndZero(0.13333, 0.2));

        //1.1.6
        System.out.println("==1.1.6==");
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }

        //1.1.7
        System.out.println("==1.1.7==");
        //a
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001)
            t = (9.0 / t + t) / 2.0;
        StdOut.printf("%.5f\n", t);
        //b
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);

        //1.1.8
        System.out.println("==1.1.8==");

        System.out.println('b');

        System.out.println('b' + 'c');

        System.out.println((char) ('a' + 4));

        //1.1.9
        System.out.println("==1.1.9==");
        int twoHundredAndThirtyThree = 233;
        System.out.println(binaryRepresentation(twoHundredAndThirtyThree));
        System.out.println(binaryRepresentation(a));
        System.out.println(binaryRepresentation(b));
        System.out.println(binaryRepresentation(0));

        //1.1.11
        System.out.println("==1.1.11==");
        boolean[][] twoByTwo = {{true, false}, {false, true}};
        printArrayWithAsterisks(twoByTwo);
        boolean[][] twoByThree = {{true, false}, {false, true}, {false, true}};
        printArrayWithAsterisks(twoByThree);
        boolean[][] threeByTwo = {{true, false, true}, {false, true, true}};
        printArrayWithAsterisks(threeByTwo);
        boolean[][] twoByOne = new boolean[2][1];
        twoByOne[0][0] = true;
        twoByOne[1][0] = true;
        printArrayWithAsterisks(twoByOne);
        System.out.println("twoByOne.length:" + twoByOne.length);
        System.out.println("twoByOne[0].length:" + twoByOne[0].length);


        //1.1.12
        System.out.println("==1.1.12==");
        int[] oneTwelve = new int[10];
        for (int i = 0; i < 10; i++)
            oneTwelve[i] = 9 - i;
        for (int i = 0; i < 10; i++)
            oneTwelve[i] = oneTwelve[oneTwelve[i]];
        for (int i = 0; i < 10; i++)
            System.out.println(i);

        //1.1.13
        System.out.println("==1.1.13==");
        System.out.println("Before:");
        printArrayWithAsterisks(twoByThree);
        System.out.println("After:");
        printArrayWithAsterisks(transposeMatrix(twoByThree));

        //1.1.14 -- need to read about logarithms

        //1.1.15
        System.out.println("==1.1.15==");
        int N = 30;
        int M = 10;

        int[] n = new int[N];
        for (int i = 0; i < N; i++)
            n[i] = StdRandom.uniform(M);

        for (int i = 0; i < N; i++)
            StdOut.printf("%2d", n[i]);

        int[] h = histogram(n, M);

        StdOut.println("\n");
        for (int i = 0; i < M; i++)
            StdOut.printf("%4d", h[i]);


    }

    public static int[] histogram(int[] series, int M) {
        int[] m = new int[M];
        int counter = 0;
        for (int i = 0; i < series.length; i++) {
            if(series[i] < M) {
                m[series[i]] = m[i]++;
            }
        }
        return m;
    }

    public static boolean strictlyBetweenOneAndZero(double x, double y) {
        return ((0 < x && x < 1) && (0 < y && y < 1)) ? true : false;
    }

    public static String binaryRepresentation(int myInt) {
        if (myInt != 0) {
            Deque<Integer> stack = new ArrayDeque<>();
            while (myInt > 0) {
                stack.push(myInt % 2);
                myInt = myInt / 2;
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.toString();
        } else {
            return "0";
        }
    }

    public static void printArrayWithAsterisks(boolean[][] biDimensionalArray) {
        System.out.print("  ");
        for (int i = 0; i < biDimensionalArray.length; i++) {
            System.out.print(i);
        }
        System.out.print("\n\r");
        for (int i = 0; i < biDimensionalArray.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < biDimensionalArray[0].length; j++) {
                if (biDimensionalArray[i][j]) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n\r");
        }
    }

    public static boolean[][] transposeMatrix(boolean[][] biDimensionalArray) {
        boolean[][] transposed = new boolean[biDimensionalArray[0].length][biDimensionalArray.length];
        for (int i = 0; i < biDimensionalArray[0].length; i++) {
            for (int j = 0; j < biDimensionalArray.length; j++) {
                 transposed[i][j]=biDimensionalArray[j][i];
            }
        }
        return transposed;
    }
}
