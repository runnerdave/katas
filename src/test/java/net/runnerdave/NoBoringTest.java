package net.runnerdave;

/**
 * Created by davidajimenez on 22/05/2016.
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class NoBoringTest {

    private static void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }
    @Test
    public void test1() {
        System.out.println("Fixed Tests: noBoringZeros");
        testing(NoBoring.noBoringZeros(1450), 145);
        testing(NoBoring.noBoringZeros(960000), 96);
        testing(NoBoring.noBoringZeros(1050), 105);
        testing(NoBoring.noBoringZeros(-1050), -105);
        testing(NoBoring.noBoringZeros(0), 0);

        testing(NoBoring.noBoringZerosCooler(1450), 145);
    }
}