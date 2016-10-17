package net.runnerdave;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by runnerdave on 16/10/16.
 */
public class CodilityDemoTest {

    @Test
    public void test01() {
        assertEquals(3, CodilityDemo.solution1("win"));
    }

    @Test
    public void test02() {
        assertEquals(1, CodilityDemo.solution(new int[]{-1, 3, -4, 5, 1, -6, 2, 1}));
    }

    @Test
    public void test03() {
        assertEquals(1, CodilityDemo.solution(new int[]{2,2,2}));
    }

    //[0, -2147483648, -2147483648] this one returns 0 with solution but that is wrong, that is why BigInteger is needed
    @Test
    public void test04() {
        assertEquals(0, CodilityDemo.solution(new int[]{0, -2147483648, -2147483648}));
    }

    @Test
    public void test05() {
        assertEquals(-1, CodilityDemo.solutionBigInt(new int[]{0, -2147483648, -2147483648}));
    }

    @Test
    public void test06() {
        assertEquals(-1, CodilityDemo.solutionBigIntWithMap(new int[]{0, -2147483648, -2147483648}));
    }

    @Test
    public void test07() {
        assertEquals(1, CodilityDemo.solutionBigIntWithMap(new int[]{-1, 3, -4, 5, 1, -6, 2, 1}));
    }

    @Test
    public void test08() {
        assertEquals(1, CodilityDemo.solutionBigIntWithMap(new int[]{2,2,2}));
    }

    @After
    public void cleanup() {
        CodilityDemo.mapBigIntLeft = new HashMap<>();
        CodilityDemo.mapBigIntRight = new HashMap<>();
    }
}
