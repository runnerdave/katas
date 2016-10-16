package net.runnerdave;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by runnerdave on 16/10/16.
 */
public class CodilityRealTest {

    @Test
    public void test02() {
        assertEquals(0, CodilityReal.solution(new int[]{-1, 3, -4, 5, 1, -6, 2, 1}));
    }

    @Test
    public void test03() {
        CodilityReal cdr = new CodilityReal();
        assertEquals(6, cdr.solution(new int[]{40, 40, 100, 80, 20}, new int[]{3, 3, 2, 2, 3}, 3, 5, 200));
    }

    @Test
    public void test04() {
        CodilityReal cdr = new CodilityReal();
        assertEquals(5, cdr.solution(new int[]{60, 80, 40}, new int[]{2, 3, 5}, 5, 2, 200));
    }

    @Test
    public void test05() {
        CodilityReal cdr = new CodilityReal();
        assertEquals(2, cdr.solution(new int[]{60}, new int[]{2}, 5, 2, 200));
    }

    @Test
    public void test06() {
        CodilityReal cdr = new CodilityReal();
        assertEquals(6, cdr.solution(new int[]{60, 80, 40}, new int[]{2, 3, 5}, 5, 2, 80));
    }
}
