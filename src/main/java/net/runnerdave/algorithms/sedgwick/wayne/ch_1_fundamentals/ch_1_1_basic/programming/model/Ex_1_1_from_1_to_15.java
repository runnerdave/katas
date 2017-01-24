package net.runnerdave.algorithms.sedgwick.wayne.ch_1_fundamentals.ch_1_1_basic.programming.model;

import net.runnerdave.algorithms.sedgwick.wayne.StdOut;

import java.io.IOException;

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
        for (int i = 0; i <= 15; i++)
        {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }

        //1.1.7
        System.out.println("==1.1.7==");
        //a
        double t = 9.0;
        while (Math.abs(t - 9.0/t) > .001)
            t = (9.0/t + t) / 2.0;
        StdOut.printf("%.5f\n", t);
        //b
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);

    }

    public static boolean strictlyBetweenOneAndZero(double x, double y) {
        return ((0< x && x<1) && (0<y && y<1)) ? true : false;
    }
}
