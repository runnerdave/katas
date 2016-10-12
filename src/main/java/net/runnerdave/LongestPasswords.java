package net.runnerdave;

import java.util.*;

/**
 * Created by davidajimenez on 12/10/2016.
 * <p>
 * it has to contain only alphanumerical characters (a−z, A−Z, 0−9);
 * there should be an even number of letters;
 * there should be an odd number of digits.
 */
public class LongestPasswords {

    static Map<Integer, String> validWords = new HashMap<>();

    public static int solution(String s) {
        int length = -1;
        String[] wordsArray = s.split(" ");
        for (int i = 0; i < wordsArray.length; i++) {
            if (evaluateOnlyAlphanumerical(wordsArray[i]) &&
                    evaluateEvenLetters(wordsArray[i]) &&
                    evaluateOddNumbers(wordsArray[i])) {
                validWords.put(wordsArray[i].length(), wordsArray[i]);
            }
        }
        if (validWords.size() > 0) {
            Set<Integer> keys = validWords.keySet();
            List<Integer> sortedList = new ArrayList<>(keys);
            Collections.sort(sortedList);
            length = sortedList.get(sortedList.size() - 1);
        }
        return length;
    }

    public static boolean evaluateEvenLetters(String s) {
        int numberOfLetters = 0;
        for (char ch : s.toCharArray()){
            if (Character.isAlphabetic(ch)) {
                numberOfLetters++;
            }
        }
        return numberOfLetters%2==0?true:false;
    }

    public static boolean evaluateOddNumbers(String s) {
        int numberOfDigits = 0;
        for (char ch : s.toCharArray()){
            if (Character.isDigit(ch)) {
                numberOfDigits++;
            }
        }
        return numberOfDigits%2==0?false:true;
    }

    public static boolean evaluateOnlyAlphanumerical(String s) {
        return !s.matches("^.*[^a-zA-Z0-9 ].*$");
    }


}
