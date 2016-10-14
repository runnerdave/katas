package net.runnerdave;

/**
 * Created by davidajimenez on 13/10/2016. solution for this problem:
 * https://codility.com/programmers/lessons/90-
 * tasks_from_indeed_prime_2015_challenge/flood_depth/
 */
public class FloodDepth {

    // returns maximum depth of water
    public static int solution(int[] A) {
        int maxDepth = 0;
        int firstEdge = A[0];
        int secondEdge = 0;
        int depth = 0;


        for (int i = 0; i < (A.length - 1); i++) {
            if (A[i] > A[i + 1]) {
                firstEdge = A[i];
                depth = A[i] - A[i + 1];
                if (maxDepth < depth) {
                    maxDepth = depth;
                }
            } else if (A[i + 1] >= firstEdge) {
                secondEdge = A[i + 1];
            }
        }

        //run in reverse and pick the smallest of the two maxDepths


        if (secondEdge == 0) {
            maxDepth = 0;
        }
        return maxDepth;
    }
}
