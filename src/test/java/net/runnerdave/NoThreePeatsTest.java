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
    private int[] array5 = {1, 2, 56, 67, 6, 7, 6, 0, 67};

    @Test(expected = Test.None.class /* no exception expected */)
    public void testSortSolutionNoThreepeat() throws Exception {
        NoThreePeats.solutionWithSort(array1);
    }

    @Test
    public void testSortSolutionTreepeatFound() throws Exception {
        thrown.expect(Exception.class);
        NoThreePeats.solutionWithSort(array2);
    }

    @Test(expected = Test.None.class /* no exception expected */)
    public void testSortSolutionNoThreepeatAnotherArray() throws Exception {
        NoThreePeats.solutionWithSort(array3);
    }

    @Test
    public void testSortSolutionThreepeatFoundAnotherArray() {
        try {
            NoThreePeats.solutionWithSort(array4);
            fail("it should have thrown an exception");
        } catch (Exception e) {
            assertThat(e, Matchers.isA((Class<Exception>) e.getClass()));
        }
    }

    @Test
    public void testSortSolutionThreepeatFoundYetAnotherArray() throws Exception {
        thrown.expect(Exception.class);
        NoThreePeats.solutionWithMap(array2);
    }

    @Test(expected = Test.None.class /* no exception expected */)
    public void testSortSolutionNoThreepeatYetAnotherArray() throws Exception {
        NoThreePeats.solutionWithSort(array5);
    }

    @Test
    public void testMapSolutionThreePeatFound() {
        try {
            NoThreePeats.solutionWithMap(array4);
            fail("it should have thrown an exception");
        } catch (Exception e) {
            assertThat(e, Matchers.isA((Class<Exception>) e.getClass()));
        }
    }

    @Test(expected = Test.None.class /* no exception expected */)
    public void testMapSolutionNoThreepeatAnotherArray() throws Exception {
        NoThreePeats.solutionWithMap(array3);
    }

    @Test
    public void testWithMapLongSolutionThreepeatFound() {
        try {
            NoThreePeats.solutionWithMapLong(array4);
            fail("it should have thrown an exception");
        } catch (Exception e) {
            assertThat(e, Matchers.isA((Class<Exception>) e.getClass()));
        }
    }

    @Test
    public void testSimpleLoopThreepeatFound() {
        try {
            NoThreePeats.solutionWithSimpleLoop(array4);
            fail("it should have thrown an exception");
        } catch (Exception e) {
            assertThat(e, Matchers.isA((Class<Exception>) e.getClass()));
        }
    }

    @Test(expected = Test.None.class /* no exception expected */)
    public void testSimpleLoopSolutionNoThreepeatAnotherArray() throws Exception {
        NoThreePeats.solutionWithSimpleLoop(array3);
    }

    @Test(expected = Test.None.class /* no exception expected */)
    public void testSimpleLoopSolutionNoThreepeatYetAnotherArray() throws Exception {
        NoThreePeats.solutionWithSimpleLoop(array5);
    }
}
