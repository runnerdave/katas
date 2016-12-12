package net.runnerdave;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by David A. Jiménez (e67997) on 12/12/2016.
 */
public class ArithmeticFunctionTest {
    @Test
    public void testBasic() {
        assertEquals("'add' should return the two numbers added together!", 3, ArithmeticFunction.arithmetic(1, 2, "add"), 1);
        assertEquals("'subtract' should return a mimus b!", 6, ArithmeticFunction.arithmetic(8, 2, "subtract"), 1);
        assertEquals("'multiply' should return a multiplied by b!", 10, ArithmeticFunction.arithmetic(5, 2, "multiply"), 1);
        assertEquals("'divide' should return a divided by b!", 4, ArithmeticFunction.arithmetic(8, 2, "divide"), 1);
    }

    @Test
    public void testBasicCool() {
        assertEquals("'add' should return the two numbers added together!", 3, ArithmeticFunction.arithmeticCool(1, 2, "add"), 1);
        assertEquals("'subtract' should return a mimus b!", 6, ArithmeticFunction.arithmeticCool(8, 2, "subtract"), 1);
        assertEquals("'multiply' should return a multiplied by b!", 10, ArithmeticFunction.arithmeticCool(5, 2, "multiply"), 1);
        assertEquals("'divide' should return a divided by b!", 4, ArithmeticFunction.arithmeticCool(8, 2, "divide"), 1);
    }
}
