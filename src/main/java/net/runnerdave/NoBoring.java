package net.runnerdave;

/**
 * Created by davidajimenez on 22/05/2016.
 */
public class NoBoring {
    public static int noBoringZeros(int n) {
        int noZeroAtEnd=0;
        if (n!=0) {
            String number = String.valueOf(n);

            char[] digits1 = number.toCharArray();
            char[] digits2 = new char[digits1.length];
            int finalLength = digits1.length;
            boolean isBoring = true;
            for (int i = digits1.length-1; i >= 0 ; i--){
                char c = digits1[i];

                if(c!='0' || !isBoring){
                    digits2[i] = c;
                    isBoring = false;
                } else {
                    finalLength--;
                }

            }
            char[] digits3 = new char[finalLength];
            for(int i=0; i<digits3.length;i++) {
                digits3[i] = digits2[i];
            }
            String b = new String(digits3);
            noZeroAtEnd = Integer.valueOf(b);
        }
        return noZeroAtEnd;
    }


    public static int noBoringZerosCooler(int n) {
        String parsedNumber = String.valueOf(n);
        int lastZeros = 0;
        for (int i = 0; i < parsedNumber.length(); i++) {
            if (parsedNumber.substring(i, i + 1).equals("0")) lastZeros++;
            else lastZeros = 0;
        }
        return (parsedNumber.length()>1) ? Integer.parseInt(parsedNumber.substring(0,parsedNumber.length()-lastZeros)) : n;
    }

    public static int noBoringZerosCoolest(int n) {
        if (n == 0)
            return n;

        while (n % 10 == 0)
            n /= 10;

        return n;
    }

}