package net.runnerdave;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davidajimenez on 15/10/2016.
 */
public class DwarfsRaftingTest {
    @Test
    public void test0_2() {
        assertEquals(6, DwarfsRafting.solution(4, "1B 1C 4B 1D 2A", "3B 2D"));
    }


}
