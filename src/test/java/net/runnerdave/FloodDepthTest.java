package net.runnerdave;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by davidajimenez on 13/10/2016.
 */
public class FloodDepthTest {
	@Test
	public void test0() {
		assertEquals(2, FloodDepth.solution(new int[] { 1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2 }));
	}

	@Test
	public void test1() {
		assertEquals(3, FloodDepth.solution(new int[] { 4, 1, 4 }));
	}
	
	@Test
	public void test2() {
		assertEquals(0, FloodDepth.solution(new int[] { 2, 1 }));
	}
	
	@Test
	public void test3() {
		assertEquals(0, FloodDepth.solution(new int[] { 1, 2 }));
	}
	
	@Test
	public void test4() {
		assertEquals(0, FloodDepth.solution(new int[] { 3, 2, 1 }));
	}
	
	@Test
	public void test5() {
		assertEquals(1, FloodDepth.solution(new int[] { 3, 1, 2 }));
	}
}
