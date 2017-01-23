package net.runnerdave;

/**
 * Created by David A. Jiménez (e67997) on 23/01/2017.
 */
public class TowerOfHanoi {
    static int[] peg1;
    static int[] peg2;
    static int[] peg3;

//    static boolean isSetupForStart() {
//        return peg2.
//    }

    static void initialize(int size) {
        peg1 = new int[size];
        peg2 = new int[size];
        peg3 = new int[size];

        for (int i = 0; i < size; i++) {
            peg1[i] = size - i;
        }
    }

    static void solve(int size) {
        initialize(size);

    }

    static void moveDisc() {
        if(occupiedSlots(peg1) > 0){

        }
    }

    static int occupiedSlots(int[] array) {
        int count = 0;
        for (int i : array
                ) {
            if (i != 0) {
                count++;
            }
        }
        return count;
    }

    static int removePegTopDisc(int[] array) {
        int top = 0;
        for (int i = 0; i < array.length; i++) {
            int current=array[i];
            int prev = 0;
            if (i>0) {
                prev = array[i-1];
            }
            if (current==0) {
                top=prev;
                array[i] = 0;
                break;
            } else if(i == array.length-1){
                top=current;
                array[i] = 0;
            }
        }
        return top;
    }
}
