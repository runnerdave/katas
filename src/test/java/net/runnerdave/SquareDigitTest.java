package net.runnerdave;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SquareDigitTest {
    @Test
    public void testMine() {


        long start = System.currentTimeMillis();
        assertEquals(811181, new SquareDigit().squareDigits(9119));
        long end = System.currentTimeMillis();
        System.out.println("DEBUG: Logic A toke " + (end - start) + " MilliSeconds");


    }

    @Test
    public void testBestPractices() {

        long start = System.currentTimeMillis();
        assertEquals(811181, new SquareDigit().squareDigitsBestPractices(9119));
        long end = System.currentTimeMillis();
        System.out.println("DEBUG: Logic A toke " + (end - start) + " MilliSeconds");
    }

    @Test
    public void testCool() {

        long start = System.currentTimeMillis();
        assertEquals(811181, new SquareDigit().squareDigitsCool(9119));
        long end = System.currentTimeMillis();
        System.out.println("DEBUG: Logic A toke " + (end - start) + " MilliSeconds");
    }

}
