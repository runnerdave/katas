package net.runnerdave;

import java.util.ArrayList;
import java.util.List;

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

        if (secondEdge == 0) {
            maxDepth = 0;
        }

        //run in reverse and pick the smallest of the two maxDepths
        int reverseMaxDepth = solutionArrayInReverse(A);

        //return maxDepth;
        return maxDepth < reverseMaxDepth ? reverseMaxDepth : maxDepth;
    }

    public static int solutionArrayInReverse(int[] A) {
        int maxDepth = 0;
        int firstEdge = A[0];
        int secondEdge = 0;
        int depth = 0;


        for (int i = (A.length - 1); i > 0; i--) {
            if (A[i - 1] < A[i]) {
                firstEdge = A[i];
                depth = A[i] - A[i - 1];
                if (maxDepth < depth) {
                    maxDepth = depth;
                }
            } else if (A[i - 1] >= firstEdge) {
                secondEdge = A[i - 1];
            }
        }

        if (secondEdge == 0) {
            maxDepth = 0;
        }
        return maxDepth;
    }



    public static int solutionWithEdges(int[] A) {
        int maxDepth = 0;
        int firstEdge = A[0];
        int secondEdge = 0;
        int depth = 0;
        boolean inContainer = false;
        int containerMaxDepth = 0;

        for (int i = 0; i < (A.length - 1); i++) {

            if (A[i] > A[i + 1]) {

                if (!inContainer) {
                    firstEdge = A[i];
                    inContainer = true;
                }
                depth = firstEdge - A[i + 1];

                if (containerMaxDepth < depth) {
                    containerMaxDepth = depth;
                }

            } else if (inContainer && A[i + 1] >= firstEdge) {
                //solves 3,2,3 and 3,2,4 but fails at 4,2,3,4
                secondEdge = A[i + 1];
                inContainer = false;
                if (maxDepth < containerMaxDepth) {
                    maxDepth = containerMaxDepth;
                }
                containerMaxDepth = 0;
            } else if (inContainer && (i+2) < A.length ) {
                //run a while until i


                if(A[i+2] < A[i+1]) {
                    secondEdge = A[i + 1];
                    inContainer = false;
                    containerMaxDepth = containerMaxDepth - (firstEdge - secondEdge);
                    if (maxDepth < containerMaxDepth) {
                        maxDepth = containerMaxDepth;
                    }
                    containerMaxDepth = 0;
                }
            } else if (inContainer && (i+2) == A.length ) {
                if(A[i] < A[i+1]) {
                    secondEdge = A[i + 1];
                    inContainer = false;
                    containerMaxDepth = containerMaxDepth - (firstEdge - secondEdge);
                    if (maxDepth < containerMaxDepth) {
                        maxDepth = containerMaxDepth;
                    }
                    containerMaxDepth = 0;
                }
            }
        }

        if (secondEdge == 0) {
            maxDepth = 0;
        }


        //return maxDepth;
        return maxDepth;
    }

    public static int solutionWithEdges2(int[] A) {
        int maxDepth = 0;
        int firstEdge = A[0];
        int secondEdge = 0;
        int depth = 0;
        boolean inContainer = false;
        int containerMaxDepth = 0;

        for (int i = 0; i < (A.length - 1); i++) {

            if (A[i] > A[i + 1]) {

                if (!inContainer) {
                    firstEdge = A[i];
                    inContainer = true;
                }
                depth = firstEdge - A[i + 1];

                if (containerMaxDepth < depth) {
                    containerMaxDepth = depth;
                }

            } else if (inContainer && A[i + 1] >= firstEdge) {
                //solves 3,2,3 and 3,2,4 but fails at 4,2,3,4
                secondEdge = A[i + 1];
                inContainer = false;
                if (maxDepth < containerMaxDepth) {
                    maxDepth = containerMaxDepth;
                }
                containerMaxDepth = 0;
            } else if (inContainer && A[i + 1] < firstEdge) {
                //check if second last if so stop here
                if (inContainer && (i+2) == A.length ) {
                    if (A[i] < A[i + 1]) {
                        secondEdge = A[i + 1];
                        inContainer = false;
                        containerMaxDepth = containerMaxDepth - (firstEdge - secondEdge);
                        if (maxDepth < containerMaxDepth) {
                            maxDepth = containerMaxDepth;
                        }
                        containerMaxDepth = 0;
                    }
                } else {
                    continue;
                }
            }
        }

        if (secondEdge == 0) {
            maxDepth = 0;
        }

        return maxDepth;
    }

    public static int solutionWithEdges3(int[] A) {
        int maxDepth = 0;
        int firstEdge = A[0];
        int secondEdge = 0;
        int depth = 0;
        boolean inContainer = false;
        int containerMaxDepth = 0;

        for (int i = 0; i < (A.length - 1); i++) {

            if (A[i] > A[i + 1]) {

                if (!inContainer) {
                    firstEdge = A[i];
                    inContainer = true;
                }
                depth = firstEdge - A[i + 1];

                if (containerMaxDepth < depth) {
                    containerMaxDepth = depth;
                }

            } else if (inContainer && A[i + 1] >= firstEdge) {
                //solves 3,2,3 and 3,2,4 but fails at 4,2,3,4
                secondEdge = A[i + 1];
                inContainer = false;
                if (maxDepth < containerMaxDepth) {
                    maxDepth = containerMaxDepth;
                }
                containerMaxDepth = 0;
            } else if (inContainer && A[i + 1] < firstEdge) {
                //check if second last if so stop here
                if ((i+2) == A.length ) {
                    if (A[i] < A[i + 1]) {
                        secondEdge = A[i + 1];
                        inContainer = false;
                        containerMaxDepth = containerMaxDepth - (firstEdge - secondEdge);
                        if (maxDepth < containerMaxDepth) {
                            maxDepth = containerMaxDepth;
                        }
                        containerMaxDepth = 0;
                    }
                } else {
                    if (A[i] < A[i + 1]) {
                        secondEdge = A[i + 1];
                        inContainer = false;
                        containerMaxDepth = containerMaxDepth - (firstEdge - secondEdge);
                        if (maxDepth < containerMaxDepth) {
                            maxDepth = containerMaxDepth;
                        }
                    }
                }
            }
        }

        if (secondEdge == 0) {
            maxDepth = 0;
        }

        return maxDepth;
    }

}
