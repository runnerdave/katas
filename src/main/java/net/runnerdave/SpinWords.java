package net.runnerdave;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by davidajimenez on 12/09/2016.
 */
public class SpinWords {

    public String spinWords(String sentence) {
        String[] strs = sentence.split(" ");
        StringBuilder converted = new StringBuilder();
        for(int i=0; i<strs.length; i++) {
            StringBuilder reversed;
            if(strs[i].length() >=5) {
                reversed = new StringBuilder(strs[i]).reverse();
            } else {
                reversed = new StringBuilder(strs[i]);
            }
            if(i>0){
                converted.append(" ").append(reversed);
            } else {
                converted.append(reversed);
            }
        }
        return converted.toString();
    }

    public String spinWordsBesser(String sentence) {

        return Arrays.stream(sentence.split(" "))
                .map(i -> i.length() > 4 ? new StringBuilder(i).reverse().toString() : i)
                .collect(Collectors.joining(" "));
    }
}
