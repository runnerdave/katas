package net.runnerdave;

import static org.junit.Assert.*;
import java.math.BigInteger;
import java.util.Random;
import org.junit.Test;

/**
 * Created by davidajimenez on 11/10/2016.
 */
public class SumFctTest {
    @Test
    public void test0() {
        assertEquals(BigInteger.valueOf(28), SumFct.perimeter(BigInteger.valueOf(3)));
    }
    @Test
    public void test1() {
        assertEquals(BigInteger.valueOf(80), SumFct.perimeter(BigInteger.valueOf(5)));
    }
    @Test
    public void test2() {
        assertEquals(BigInteger.valueOf(216), SumFct.perimeter(BigInteger.valueOf(7)));
    }
    @Test
    public void test3() {
        assertEquals(BigInteger.valueOf(14098308), SumFct.perimeter(BigInteger.valueOf(30)));
    }
    @Test
    public void test4() {
        assertEquals(BigInteger.valueOf(80), SumFct.perimeterBigInt(BigInteger.valueOf(5)));
    }
    @Test
    public void test5() {
        assertEquals(BigInteger.valueOf(14098308), SumFct.perimeterBigInt(BigInteger.valueOf(30)));
    }
    @Test
    public void testFibonacciBigInt() {
        assertEquals(BigInteger.valueOf(5), SumFct.fibonacciBigInt(BigInteger.valueOf(5)));
    }

}
