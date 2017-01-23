package net.runnerdave;

import org.junit.Test;

/**
 * Created by David A. Jiménez (e67997) on 16/01/2017.
 * example from: https://dzone.com/articles/how-to-debug-java-with-intellij-breakpoints-evalua
 */
public class ArrayPrinterTest {
    /**
     * this test has two problems, first the squareWidth+1 should not have +1
     * and then the method print2DStringArrayIterators should not have a break command.
     */
    @Test
    public void createSquare2dArray() {

        int squareWidth = 16;

        String[][] square = new String[squareWidth][];

        for (int row = 0; row < square.length; row++) {
            square[row] = new String[squareWidth];
            for (int i = 0; i < (squareWidth + 1); i++) {
                square[row][i] = "*";
            }
        }

        new ArrayPrinter().print2DStringArrayIterators(square);
        System.out.println("");
    }
}
