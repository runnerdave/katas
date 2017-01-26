package net.runnerdave;

import java.util.Arrays;

/**
 * Created by runnerdave on 24/01/17.
 */
public class CodilityIntelliMatic1 {

    public static int solution(int i) {
        int biggestInFamily = i;
        String number = String.valueOf(i);

        char[] digits1 = number.toCharArray();
        System.out.println(Arrays.toString(digits1));

        Arrays.sort(digits1);
        System.out.println(Arrays.toString(digits1));
        int head = Character.getNumericValue(digits1[digits1.length-1]);
        System.out.println(head);
        StringBuilder sb = new StringBuilder();


        for (int j = (digits1.length - 1); j >= 0; j--) {
            sb.append(digits1[j]);
        }

        System.out.println(Integer.valueOf(sb.toString()));

        biggestInFamily = Integer.valueOf(sb.toString());

        return biggestInFamily;
    }

}
