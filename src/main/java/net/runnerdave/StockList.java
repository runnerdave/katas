package net.runnerdave;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by davidajimenez on 13/09/2016.
 * <p>
 * A bookseller has lots of books classified in 26 categories labeled A, B, ... Z. Each book has a code c of 3, 4, 5 or more capitals letters. The 1st letter of a code is the capital letter of the book category. In the bookseller's stocklist each code c is followed by a space and by a positive integer n (int n >= 0) which indicates the quantity of books of this code in stock.
 * <p>
 * In a given stocklist all codes have the same length and all numbers have their own same length (can be different from the code length).
 * <p>
 * For example an extract of one of the stocklists could be:
 * <p>
 * L = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"}.
 * In this stocklist all codes have a length of five and all numbers have a length of two.
 * <p>
 * You will be given a stocklist (e.g. : L) and a list of categories in capital letters e.g :
 * <p>
 * M = {"A", "B", "C", "W"}
 * and your task is to find all the books of L with codes belonging to each category of M and to sum their quantity according to each category.
 * You will have first to determine the common length of the codes and the common length of the quantities in L.
 * <p>
 * For the lists L and M of example you have to return the string (in Haskell/Clojure a list of pairs):
 * <p>
 * (A : 20) - (B : 114) - (C : 50) - (W : 0)
 * where A, B, C, W are the categories, 20 is the sum of the unique book of category A, 114 the sum corresponding to "BKWRK" and "BTSQZ",
 * 50 corresponding to "CDXEF" and 0 to category 'W' since there are no code beginning with W.
 * <p>
 * If L or M are empty return string is "" (Clojure should return an empty array instead).
 */
public class StockList {
    // 1st parameter is the stocklist (L in example),
    // 2nd parameter is list of categories (M in example)
    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        Map<String, List<String>> map = Arrays.stream(lstOfArt).collect(Collectors.groupingBy(s -> s.substring(0, 1)));
//        System.out.println(map);
        StringBuilder str = new StringBuilder();
        if (lstOfArt.length > 0 && lstOf1stLetter.length > 0) {
            for (int i = 0; i < lstOf1stLetter.length; i++) {
    //            List values = map.get(lstOf1stLetter[i]).stream().collect(Collectors.toList());
    //            System.out.println(values);
                if (str.length() > 0) {
                    str.append(" - ");
                }
                if (map.containsKey(lstOf1stLetter[i])) {
                    int value = map.get(lstOf1stLetter[i])
                            .stream().mapToInt(w -> w != null ? Integer.valueOf(w.split(" ")[1]) : 0)
                            //.peek(System.out::println)
                            .sum();

                    str.append("(").append(lstOf1stLetter[i]).append(" : ").append(value + "").append(")");

                } else {
                    str.append("(").append(lstOf1stLetter[i]).append(" : 0)");
                }
            }
        }
        return str.toString();
    }

    public static String stockSummaryBetter(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length <= 0 && lstOf1stLetter.length <= 0)
            return "";

        Map<String, List<String>> map = Arrays.stream(lstOfArt).collect(Collectors.groupingBy(s -> s.substring(0, 1)));

//        System.out.println(map);
//        System.out.println(lstOf1stLetter);

        String myStr = Arrays.stream(lstOf1stLetter)
                                //.peek(init -> System.out.println("init" + init))
                                .map(initial -> String.format("(%s : %d)",
                                                                                initial,
                                                                                map.getOrDefault(initial, Arrays
                                                                                                .asList("XX 0"))
                                                                                .stream()
                                                                                //.peek(k->System.out.println("k:" + k))
                                                                                .collect(Collectors.summingInt(v->Integer.valueOf(v.split(" ")[1])))))
                                                    .collect(Collectors.joining(" - "));



        return myStr;
    }

    private static class Book {
        public final String category;
        public final String code;
        public final int quantity;

        public Book(String label) {
            category = label.substring(0,1);
            code = label.split(" ")[0].substring(1);
            quantity = Integer.parseInt(label.split(" ")[1]);
        }
    }

    public static String stockSummaryGreat(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0)
            return "";
        Map<String, Integer> categoryCounts = Arrays.stream(lstOfArt)
                //.peek(System.out::println)
                .map(Book::new)
                //.peek(b->System.out.println(b.code))
                .collect(Collectors.groupingBy(book -> book.category,
                        Collectors.summingInt(book -> book.quantity)));
//        System.out.println(categoryCounts);
        return Arrays.stream(lstOf1stLetter)
                .map(initial -> String.format("(%s : %d)",
                        initial, categoryCounts.getOrDefault(initial, 0)))
                .collect(Collectors.joining(" - "));
    }
}
