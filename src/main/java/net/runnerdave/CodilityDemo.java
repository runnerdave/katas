package net.runnerdave;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by runnerdave on 16/10/16.
 */
public class CodilityDemo {

    public static int solution1(String S) {
        return S.length();
    }


    public static int solution(int[] A) {
        int equilibrium = -1;
        for (int i = 0; i < A.length; i++) {
            int rightTotal = 0;
            for (int j = i + 1; j < A.length; j++) {
                rightTotal += A[j];
            }
            int leftTotal = 0;
            for (int j = 0; j < i; j++) {
                leftTotal += A[j];
            }
            if (leftTotal - rightTotal == 0) {
                return i;
            }
        }
        return equilibrium;
    }


    public static int solutionBigInt(int[] A) {
        int equilibrium = -1;
        for (int i = 0; i < A.length; i++) {
            BigInteger rightTotal = BigInteger.ZERO;
            for (int j = i + 1; j < A.length; j++) {
                rightTotal = rightTotal.add(BigInteger.valueOf(A[j]));
            }
            BigInteger leftTotal = BigInteger.ZERO;
            for (int j = 0; j < i; j++) {
                leftTotal = leftTotal.add(BigInteger.valueOf(A[j]));
            }
            if (leftTotal.subtract(rightTotal) == BigInteger.ZERO) {
                return i;
            }
        }
        return equilibrium;
    }

    private static Map<BigInteger, BigInteger> mapBigIntLeft = new HashMap<>();
    private static Map<BigInteger, BigInteger> mapBigIntRight = new HashMap<>();


    public static int solutionBigIntWithMap(int[] A) {
        int equilibrium = -1;
        for (int i = 0; i < A.length; i++) {
            BigInteger rightTotal = BigInteger.ZERO;
            //for (int j = i + 1; j < A.length; j++) {
            for (int j = A.length - 1; j > i; j--) {
                BigInteger val = mapBigIntRight.get(BigInteger.valueOf(j+1));
                if (val != null) {
                    rightTotal = val.add(BigInteger.valueOf(A[j]));
                } else {
                    rightTotal = rightTotal.add(BigInteger.valueOf(A[j]));
                }
                mapBigIntRight.put(BigInteger.valueOf(j), rightTotal);
            }
            BigInteger leftTotal = BigInteger.ZERO;
            for (int j = 0; j < i; j++) {
                BigInteger val = mapBigIntLeft.get(BigInteger.valueOf(j-1));
                if (val != null) {
                    leftTotal = val.add(BigInteger.valueOf(A[j]));
                } else {
                    leftTotal = leftTotal.add(BigInteger.valueOf(A[j]));
                }
                mapBigIntLeft.put(BigInteger.valueOf(j), leftTotal);
            }
            if (leftTotal.subtract(rightTotal) == BigInteger.ZERO) {
                return i;
            }
        }
        return equilibrium;
    }
}
