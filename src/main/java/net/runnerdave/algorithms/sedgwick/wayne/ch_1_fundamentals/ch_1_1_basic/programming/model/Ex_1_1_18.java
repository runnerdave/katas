package net.runnerdave.algorithms.sedgwick.wayne.ch_1_fundamentals.ch_1_1_basic.programming.model;

/**
 * Created by David A. Jiménez (e67997) on 2/02/2017.
 */
public class Ex_1_1_18 {
    /**
     * What are the values of mystery(2, 25) and mystery(3, 11)? Given positive integers
     a and b, describe what value mystery(a, b) computes. Answer the same question, but
     replace + with * and replace return 0 with return 1.
     * @param a
     * @param b
     * @return
     */
    public static int mystery(int a, int b)
    {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a+a, b/2);
        return mystery(a+a, b/2) + a;
    }
    public static void main(String[] args) {
        System.out.println(mystery(2, 5));
        System.out.println(mystery(3, 11));
    }
}
