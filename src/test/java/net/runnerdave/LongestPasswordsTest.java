package net.runnerdave;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

/**
 * Created by davidajimenez on 11/10/2016.
 */
public class LongestPasswordsTest {
    @Test
    public void test0() {
        assertEquals(7, LongestPasswords.solution("5 a0A pass007 ?xy1"));
    }

    @Test
    public void testAlphanumeric() {
        assertEquals(true, LongestPasswords.evaluateOnlyAlphanumerical("pass007"));
    }
}
