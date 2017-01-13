package net.runnerdave;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by David A. Jiménez (e67997) on 13/01/2017.
 */
public class FunWithListReduceTest {
    @Test
    public void basicTests() {
        assertEquals(0, (int) FunWithListsReduce.reduce(null, (a, b) -> a + b, 0));
        assertEquals(6, (int) FunWithListsReduce.reduce(new Node(1, new Node(2, new Node(3))), (a, b) -> a + b, 0));
        assertEquals(24, (int) FunWithListsReduce.reduce(new Node(1, new Node(2, new Node(3, new Node(4)))), (a, b) -> a * b, 1));
        assertEquals("abc", FunWithListsReduce.reduce(new Node("a", new Node("b", new Node("c"))), (a, b) -> a + b, ""));
    }
}
