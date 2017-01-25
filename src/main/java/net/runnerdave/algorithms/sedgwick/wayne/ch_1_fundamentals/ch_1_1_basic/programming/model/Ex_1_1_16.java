package net.runnerdave.algorithms.sedgwick.wayne.ch_1_fundamentals.ch_1_1_basic.programming.model;

/**
 * Created by davidajimenez on 25/01/2017.
 */
public class Ex_1_1_16 {
    static int counter = 0;
    static int counter2 = 0;
    public static String exR1(int n) {
        counter++;
        if (n <= 0) return "";
        counter2++;
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    public static void main(String[] args) {
//        System.out.println(exR1(1));
//        System.out.println(exR1(2));
        System.out.println(exR1(3));
//        System.out.println(exR1(4));
//        System.out.println(exR1(5));
//        System.out.println(exR1(6));
        System.out.println(counter);
        System.out.println(counter2);

//        System.out.println(exR11(1));
    }

    public static String exR11(int n) {
        if (n <= 0) return "";
        return exR11(n - 1) + n;
    }
}
