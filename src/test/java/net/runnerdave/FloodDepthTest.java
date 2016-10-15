package net.runnerdave;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by davidajimenez on 13/10/2016.
 */
public class FloodDepthTest {


    @Test
    public void test0_2() {
        assertEquals(2, FloodDepth.solutionWithEdges(new int[]{1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2}));
    }

    @Test
    public void test0_3() {
        assertEquals(2, FloodDepth.solutionWithEdges2(new int[]{1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2}));
    }

    @Test
    public void test0_4() {
        assertEquals(2, FloodDepth.solutionWithEdges3(new int[]{1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2}));
    }

    @Test
    public void test1() {
        assertEquals(3, FloodDepth.solution(new int[]{4, 1, 4}));
    }

    @Test
    public void test1_1() {
        assertEquals(3, FloodDepth.solutionArrayInReverse(new int[]{4, 1, 4}));
    }

    @Test
    public void test1_2() {
        assertEquals(3, FloodDepth.solutionWithEdges(new int[]{4, 1, 4}));
    }

    @Test
    public void test1_3() {
        assertEquals(3, FloodDepth.solutionWithEdges2(new int[]{4, 1, 4}));
    }


    @Test
    public void test2() {
        assertEquals(0, FloodDepth.solution(new int[]{2, 1}));
    }

    @Test
    public void test2_3() {
        assertEquals(0, FloodDepth.solutionWithEdges2(new int[]{2, 1}));
    }


    @Test
    public void test3() {
        assertEquals(0, FloodDepth.solution(new int[]{1, 2}));
    }

    @Test
    public void test3_3() {
        assertEquals(0, FloodDepth.solutionWithEdges2(new int[]{1, 2}));
    }

    @Test
    public void test4() {
        assertEquals(0, FloodDepth.solution(new int[]{3, 2, 1}));
    }

    @Test
    public void test4_3() {
        assertEquals(0, FloodDepth.solutionWithEdges2(new int[]{3, 2, 1}));
    }

    @Test
    public void test5() {
        assertEquals(1, FloodDepth.solution(new int[]{3, 1, 2}));
    }

    @Test
    public void test5_1() {
        assertEquals(1, FloodDepth.solutionArrayInReverse(new int[]{3, 1, 2}));
    }

    @Test
    public void test5_3() {
        assertEquals(1, FloodDepth.solutionWithEdges2(new int[]{3, 1, 2}));
    }


    @Test
    public void test6_0() {
        assertEquals(2, FloodDepth.solutionWithEdges(new int[]{3, 1, 4, 2, 5, 1, 2}));
    }

    @Test
    public void test6_3() {
        assertEquals(2, FloodDepth.solutionWithEdges2(new int[]{3, 1, 4, 2, 5, 1, 2}));
    }

    @Test
    public void test6_4() {
        assertEquals(2, FloodDepth.solutionWithEdges3(new int[]{3, 1, 4, 2, 5, 1, 2}));
    }

    @Test
    public void test6_1() {
        assertEquals(0, FloodDepth.solutionArrayInReverse(new int[]{1, 2, 3}));
    }

    @Test
    public void test7() {
        assertEquals(1, FloodDepth.solution(new int[]{3, 2, 4}));
    }

    @Test
    public void test7_3() {
        assertEquals(1, FloodDepth.solutionWithEdges2(new int[]{3, 2, 4}));
    }

    @Test
    public void test8() {
        assertEquals(0, FloodDepth.solution(new int[]{1, 2, 3}));
    }

    @Test
    public void test8_1() {
        assertEquals(0, FloodDepth.solutionArrayInReverse(new int[]{1, 2, 3}));
    }

    @Test
    public void test8_3() {
        assertEquals(0, FloodDepth.solutionWithEdges2(new int[]{1, 2, 3}));
    }


    @Test
    public void test9_0() {
        assertEquals(2, FloodDepth.solutionWithEdges(new int[]{2, 1, 4, 1, 2, 2, 3}));
    }

    @Test
    public void test9_3() {
        assertEquals(2, FloodDepth.solutionWithEdges2(new int[]{2, 1, 4, 1, 2, 2, 3}));
    }

    @Test
    public void test10_0() {
        assertEquals(3, FloodDepth.solutionWithEdges(new int[]{4, 1, 1, 3, 1, 1, 5, 1, 1}));
    }

    @Test
    public void test10_3() {
        assertEquals(3, FloodDepth.solutionWithEdges2(new int[]{4, 1, 1, 3, 1, 1, 5, 1, 1}));
    }

    @Test
    public void test10_4() {
        assertEquals(3, FloodDepth.solutionWithEdges3(new int[]{4, 1, 1, 3, 1, 1, 5, 1, 1}));
    }

    @Test
    public void test11_0() {
        assertEquals(2, FloodDepth.solutionWithEdges(new int[]{4, 1, 1, 3, 1, 1, 3}));
    }

    @Test
    public void test11_3() {
        assertEquals(2, FloodDepth.solutionWithEdges2(new int[]{4, 1, 1, 3, 1, 1, 3}));
    }

    @Test
    public void test11_4() {
        assertEquals(2, FloodDepth.solutionWithEdges3(new int[]{4, 1, 1, 3, 1, 1, 3}));
    }

    @Test
    public void test12() {
        assertEquals(6, FloodDepth.solutionWithEdges3(new int[]{20, 4, 10, 1, 3}));
    }
}
