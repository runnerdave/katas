package net.runnerdave;

/**
 * Created by davidajimenez on 12/09/2016.
 */
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SpinWordsTest {
    @Test
    public void test() {
        assertEquals("emocleW", new SpinWords().spinWords("Welcome"));
        assertEquals("Hey wollef sroirraw", new SpinWords().spinWords("Hey fellow warriors"));

        assertEquals("emocleW", new SpinWords().spinWordsBesser("Welcome"));
        assertEquals("Hey wollef sroirraw", new SpinWords().spinWordsBesser("Hey fellow warriors"));
    }

}
