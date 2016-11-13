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
        assertEquals(3, TriangularTreasure.triangularFunctional(2));
    }

    @Test
    public void test_Four_Should_Be_Ten() throws Exception {
        assertEquals(10, TriangularTreasure.triangular(4));
        assertEquals(10, TriangularTreasure.triangularFunctional(4));
    }

    @Test
    public void test_Ten_reverse_should_be_four() throws  Exception {
        assertEquals(4, TriangularTreasure.reverseTriangular(10), 0.1);
    }

    @Test
    public void test_Fifteen_reverse_should_be_five() throws  Exception {
        assertEquals(5, TriangularTreasure.reverseTriangular(15), 0.1);
    }
}
