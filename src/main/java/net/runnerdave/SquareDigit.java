package net.runnerdave;

import java.util.stream.Collectors;

/**
 * Created by davidajimenez on 1/07/2016.
 */
public class SquareDigit {
    public int squareDigits(int n) {
        int length = String.valueOf(n).length();
        int[] array = new int[length];
        int i = length-1;
        while (n > 0) {
            array[i] = n % 10;
            n = n / 10;
            i--;
        }
        StringBuilder result = new StringBuilder();
        for(int j = 0; j < length; j++){
            result.append(array[j]*array[j]);
        }
        return Integer.valueOf(result.toString());
    }

    public int squareDigitsBestPractices(int n) {
        String result = "";

        while (n != 0) {
            int digit = n % 10 ;
            result = digit*digit + result ;
            n /= 10 ;
        }

        return Integer.parseInt(result) ;
    }

    public int squareDigitsCool(int n) {
        return Integer.parseInt(String.valueOf(n)
                .chars()
                .map(i -> Integer.parseInt(String.valueOf((char) i)))
                .map(i -> i * i)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("")));
    }
}
