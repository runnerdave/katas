package net.runnerdave;

import static org.junit.Assert.*;
import org.junit.Test;


/**
 * Created by davidajimenez on 13/09/2016.
 */
public class StockListTest {
    @Test
    public void test1() {
        String art[] = new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
        String cd[] = new String[] {"A", "B"};
        assertEquals("(A : 200) - (B : 1140)",
                StockList.stockSummary(art, cd));

        assertEquals("(A : 200) - (B : 1140)",
                StockList.stockSummaryBetter(art, cd));

         art = new String[]{"ABAR 200"};
         cd = new String[] {"A"};
        assertEquals("(A : 200)",
                StockList.stockSummary(art, cd));

        art = new String[]{"DRTY 600"};
        cd = new String[] {"D"};
        assertEquals("(D : 600)",
                StockList.stockSummary(art, cd));

        String L[] = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"};
        String M[] = {"A", "B", "C", "W"};
        assertEquals("(A : 20) - (B : 114) - (C : 50) - (W : 0)",
                StockList.stockSummary(L, M));
        assertEquals("(A : 20) - (B : 114) - (C : 50) - (W : 0)",
                StockList.stockSummaryGreat(L, M));

        assertEquals("(A : 20) - (B : 114) - (C : 50) - (W : 0)",
                StockList.stockSummaryBetter(L, M));

        M = new String[] {"P", "Q", "R", "S"};
        assertEquals("(P : 0) - (Q : 0) - (R : 0) - (S : 0)",
                StockList.stockSummary(L, M));

        assertEquals("(P : 0) - (Q : 0) - (R : 0) - (S : 0)",
                StockList.stockSummaryGreat(L, M));
    }
}
