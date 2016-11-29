package net.runnerdave;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by davidajimenez on 29/11/2016.
 */
public class NoThreePeatsTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private int[] array1 = {1, 2, 56, 4, 6, 7, 89, 5, 67};
    private int[] array2 = {1, 2, 56, 1, 6, 7, 89, 1, 67};
    private int[] array3 = {1, 2, 56, 1, 6, 7, 89, 5, 67};
    private int[] array4 = {1, 2, 56, 67, 6, 7, 6, 67, 67};

    @Test
    public void testSortSolution0() {
        try {
            NoThreePeats.solutionWithSort(array1);
            assertEquals(true, 1 == 1);
        } catch (Exception e) {
            //do nothing
        }
    }


    @Test
    public void testSortSolution1() throws Exception {
        thrown.expect(Exception.class);
        NoThreePeats.solutionWithSort(array2);
    }

    @Test
    public void testSortSolution2() {
        try {
            NoThreePeats.solutionWithSort(array3);
            assertEquals(true, 1 == 1);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testSortSolution3() {
        try {
            NoThreePeats.solutionWithSort(array4);
            fail("it should have thrown an exception");
        } catch (Exception e) {
            assertThat(e, Matchers.isA((Class<Exception>) e.getClass()));
        }
    }

    @Test
    public void testSortSolution4() {
        try {
            NoThreePeats.solutionWithMap(array2);
            assertEquals(true, 1 == 1);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testSortSolution5() {
        try {
            NoThreePeats.solutionWithMap(array4);
            fail("it should have thrown an exception");
        } catch (Exception e) {
            assertThat(e, Matchers.isA((Class<Exception>) e.getClass()));
        }
    }

    @Test
    public void testSortSolution6() {
        try {
            NoThreePeats.solutionWithMapLong(array4);
            fail("it should have thrown an exception");
        } catch (Exception e) {
            assertThat(e, Matchers.isA((Class<Exception>) e.getClass()));
        }
    }
}
