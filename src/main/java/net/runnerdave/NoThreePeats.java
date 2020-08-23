package net.runnerdave;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by davidajimenez on 29/11/2016.
 */
public class NoThreePeats {

    /*
     * Write a function that throws an exception if an item appears 3 times
     */
    public static void solutionWithSort(int[] arr) throws Exception {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] == arr[i + 1]) {
                if (arr[i] == arr[i + 2]) {
                    throw new Exception("threepeat!!!");
                }
            }
        }
        //check edge condition
        int length = arr.length;
        if (length > 2) {
            if (arr[length - 1] == arr[length - 2] && arr[length - 2] == arr[length - 3]) {
                throw new Exception("threepeat!!!");
            }
        }
    }

    public static void solutionWithMap(int[] arr) throws Exception {
        Map<Integer, Integer> map = populateMap(arr);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 2) {
                throw new Exception("threepeat!!!");
            }
        }

    }

    public static void solutionWithMapLong(int[] arr) throws Exception {
        Map<Integer, Long> map = populateMapWithStreams(arr);
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (entry.getValue() > 2) {
                throw new Exception("threepeat!!!");
            }
        }
    }

    public static void solutionWithSimpleLoop(int[] arr) throws Exception {
        for (int i = 0; i < arr.length; i++) {
            Integer[] tray = new Integer[3];
            tray[0] = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (tray[1] != null && tray[1] == arr[j]) {
                    throw new Exception("threepeat!!!");
                }
                if (tray[0] == arr[j]) {
                    tray[1] = arr[j];
                }
            }
        }
    }


    private static Map<Integer, Integer> populateMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            if (map.containsKey(key)) {
                int value = map.get(key);
                map.put(key, ++value);
            } else {
                map.put(key, 1);
            }
        }
        return map;
    }

    private static Map<Integer, Long> populateMapWithStreams(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Map<Integer, Long> mapByRepeats
                = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return mapByRepeats;
    }
}




