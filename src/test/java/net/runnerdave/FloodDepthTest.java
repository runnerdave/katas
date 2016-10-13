package net.runnerdave;

import static org.junit.Assert.*;
import java.math.BigInteger;
import java.util.Random;
import org.junit.Test;

/**
 * Created by davidajimenez on 13/10/2016.
 */
public class FloodDepthTest {
    @Test
    public void test0() {
        assertEquals(BigInteger.valueOf(28), FloodDepth.solution(new int[]{1,3,2,1,2,1,5,3,3,4,2}));
    }


}
