package net.runnerdave;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by runnerdave on 24/01/17.
 */
public class CodilityIntelliMatic1Test {

    @Test
    public void testSolution1() {
        assertEquals(321, CodilityIntelliMatic1.solution(213));

        assertEquals(553, CodilityIntelliMatic1.solution(553));

        assertEquals(553, CodilityIntelliMatic1.solution(535));
    }
}
