package net.runnerdave;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by davidajimenez on 13/10/2016.
 * solution for this problem:
 * https://codility.com/programmers/lessons/90-tasks_from_indeed_prime_2015_challenge/flood_depth/
 */
public class FloodDepth {
    Map<Integer, Container> containerMap = new HashMap<>();

    //returns maximum depth of water
    public static int solution(int[] A){
        int maxDepth = 0;
        int edge = A[0];
        for (int i = 0; i < (A.length - 1); i++) {
            int depth = 0;
            while(A[i]>A[i+1]) {
                depth = A[i] - A[i+1];
            }
        }
        return maxDepth;
    }

    private class Container {
        int maxDepth;
        int width;

        Container(int maxDepth, int width) {
            this.maxDepth = maxDepth;
            this.width = width;
        }
    }
}
