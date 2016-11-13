package net.runnerdave;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by davidajimenez on 15/10/2016.
 */
public class DwarfsRafting {

    static int[][] raft;

    public static int solution(int N, String S, String T) {
        int maxNumberOfDwarfs = 0;
        raft = new int[N][N];
        fillRaft(S.split(" "), T.split(" "));
        //breakIntoQuarters(raft);
        return maxNumberOfDwarfs;
    }

    static void fillRaft(String[] barrels, String[] dwarfs) {
        for (int i = 0; i < barrels.length; i++) {
            int x = getX(barrels[i]);
            int y = getY(barrels[i]);
            raft[x][y] = -1;
        }
        for (int i = 0; i < dwarfs.length; i++) {
            int x = getX(dwarfs[i]);
            int y = getY(dwarfs[i]);
            raft[x][y] = 1;
        }

    }

    static int compareQuarters(Integer[][] q1, Integer[][] q2) {
        return weightQuarter(q1) - weightQuarter(q2);
    }

    //returns number of dwarfs necessary to balance the two quarters
    //negative number means needs to be added to first
    // and positive means needs to be added to second
    static void balanceQuarters(Integer[][] q1, Integer[][] q2) {
        int diff = compareQuarters(q1, q2);
        if (diff < 0) {
            int availableSpaces = emptySpaces(q1);
            if (availableSpaces > 0 && (availableSpaces + diff) >= 0) {

                for (int i = 0; i < availableSpaces + diff; i++) {
                    fillSpace(q1);
                }
            }
        } else if (diff > 0) {
            int availableSpaces = emptySpaces(q2);
            if (availableSpaces > 0 && (availableSpaces - diff) >= 0) {
                for (int i = 0; i < availableSpaces - diff; i++) {
                    fillSpace(q2);
                }
            }
        }
    }

    static Integer[][] fillSpace(Integer[][] q) {
        for (int i = 0; i < q.length; i++) {
            for (int j = 0; j < q.length; j++) {
                if (q[i][j] == 0) {
                    q[i][j] = 1;
                    return q;

                }
            }
        }
        return q;
    }

    static int weightQuarter(Integer[][] q) {
        int weight = 0;
        for (int i = 0; i < q.length; i++) {
            for (int j = 0; j < q.length; j++) {
                if (q[i][j] == 1)
                    weight++;
            }
        }
        return weight;
    }

    static int emptySpaces(Integer[][] q) {
        int empty = 0;
        for (int i = 0; i < q.length; i++) {
            for (int j = 0; j < q.length; j++) {
                if (q[i][j] == 0)
                    empty++;
            }
        }
        return empty;
    }

    private static int getX(String s) {
        int x = Integer.valueOf(s.substring(0, 1)) - 1;
        return x;
    }

    private static int getY(String s) {
        int y = (int) s.charAt(1) - 65;
        return y;
    }

    static String printRaft() {
        String str = "";
        for (int i = 0; i < raft.length; i++) {
            for (int j = 0; j < raft.length; j++) {
                str += raft[i][j] + " ";
            }
            str += "\n";
        }
        return str;
    }

    static String printQuarter(Integer[][] q) {
        String str = "";
        for (int i = 0; i < q.length; i++) {
            for (int j = 0; j < q.length; j++) {
                str += q[i][j] + " ";
            }
            str += "\n";
        }
        return str;
    }

    static private Map<Integer, Integer[][]> breakIntoQuarters(int[][] raft) {
        Map<Integer, Integer[][]> quarters = new HashMap<>();
        int quarterSize = raft.length / 2;
        Integer[][] q1 = new Integer[quarterSize][quarterSize];
        Integer[][] q2 = new Integer[quarterSize][quarterSize];
        Integer[][] q3 = new Integer[quarterSize][quarterSize];
        Integer[][] q4 = new Integer[quarterSize][quarterSize];
        for (int i = 0; i < quarterSize; i++) {
            for (int j = 0; j < quarterSize; j++) {
                int val = raft[i][j];
                q1[i][j] = val;
            }
        }
        quarters.put(1, q1);
        for (int i = quarterSize; i < raft.length; i++) {
            for (int j = 0; j < quarterSize; j++) {
                int val = raft[i][j];
                q2[i - quarterSize][j] = val;
            }
        }
        quarters.put(2, q2);
        for (int i = 0; i < quarterSize; i++) {
            for (int j = quarterSize; j < raft.length; j++) {
                int val = raft[i][j];
                q3[i][j - quarterSize] = val;
            }
        }
        quarters.put(3, q3);
        for (int i = quarterSize; i < raft.length; i++) {
            for (int j = quarterSize; j < raft.length; j++) {
                int val = raft[i][j];
                q4[i - quarterSize][j - quarterSize] = val;
            }
        }
        quarters.put(4, q4);
        return quarters;
    }

    static boolean balanceChecker(Map<Integer, Integer[][]> quarters) {
        boolean balanced = false;
        int frontAndBackBalance = weightQuarter(quarters.get(1)) + weightQuarter(quarters.get(3)) - (weightQuarter(quarters.get(2)) + weightQuarter(quarters.get(4)));
        int leftAndRightBalance = weightQuarter(quarters.get(1)) + weightQuarter(quarters.get(2)) - (weightQuarter(quarters.get(3)) + weightQuarter(quarters.get(4)));
        return frontAndBackBalance - leftAndRightBalance == 0 ? true : false;
    }

    public static void main(String... a) {
        solution(4, "1B 1C 4B 1D 2A", "3B 2D");
        System.out.println(printRaft());
        Map<Integer, Integer[][]> quarters = breakIntoQuarters(raft);
        System.out.println("is balanced:" + balanceChecker(quarters));
        //quarters.forEach((k,v)->System.out.println("Item : " + 1 + " Count : " + printQuarter(v)));
        System.out.println(" balance 1 & 2:" + compareQuarters(quarters.get(1), quarters.get(2)));
        System.out.println(" balance 1 & 3:" + compareQuarters(quarters.get(1), quarters.get(3)));
        System.out.println(" balance 2 & 4:" + compareQuarters(quarters.get(2), quarters.get(4)));
        System.out.println(" balance 3 & 4:" + compareQuarters(quarters.get(3), quarters.get(4)));

        System.out.println(" before balance:" + printQuarter(quarters.get(1)));
        balanceQuarters(quarters.get(1), quarters.get(2));
        System.out.println(" after balance:" + printQuarter(quarters.get(1)));
    }
}
