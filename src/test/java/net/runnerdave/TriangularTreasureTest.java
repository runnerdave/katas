package net.runnerdave;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Created by David A. Jimene (e67997) on 11/11/2016.
 */
public class TriangularTreasureTest {
    @Test
    public void test_Two_Should_Be_Three() throws Exception {
        assertEquals(3, TriangularTreasure.triangular(2));
    }

    @Test
    public void test_Four_Should_Be_Ten() throws Exception {
        assertEquals(10, TriangularTreasure.triangular(4));
    }
}
