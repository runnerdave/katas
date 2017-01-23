package net.runnerdave;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by David A. Jiménez (e67997) on 23/01/2017.
 */
public class TowerOfHanoiTest {
    @Test
    public void testOccupy() {
        assertEquals(0,TowerOfHanoi.occupiedSlots(new int[3]));

        int[] array2 = new int[3];
        array2[0] = 1;
        assertEquals(1,TowerOfHanoi.occupiedSlots(array2));

        int[] array3 = new int[3];
        array3[0] = 3;
        array3[1] = 2;
        array3[2] = 1;
        assertEquals(3,TowerOfHanoi.occupiedSlots(array3));


    }

    @Test
    public void testInitialize() {
        TowerOfHanoi.initialize(3);
        assertEquals(3, TowerOfHanoi.occupiedSlots(TowerOfHanoi.peg1));
        System.out.println(Arrays.toString(TowerOfHanoi.peg1));
    }

    @Test
    public void testRemoveTopPeg() {
        int[] array = new int[3];
        array[0] = 3;
        array[1] = 2;
        assertEquals(2, TowerOfHanoi.removePegTopDisc(array));
        System.out.println(Arrays.toString(array));
        assertEquals(3, TowerOfHanoi.removePegTopDisc(array));
        System.out.println(Arrays.toString(array));
    }
}
