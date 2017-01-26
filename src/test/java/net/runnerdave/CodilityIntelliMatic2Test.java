package net.runnerdave;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by runnerdave on 24/01/17.
 */
public class CodilityIntelliMatic2Test {

    private static String log = "00:01:07,400-234-090\n"+
            "   00:05:01,701-080-080\n"+
            "   00:05:00,400-234-090";

    @Test
    public void testSolution1() {
        CodilityIntelliMatic2 cm = new CodilityIntelliMatic2();

        assertEquals(900, cm.solution(log));
    }

    @Test
    public void testFindLongestDuration() {
        CodilityIntelliMatic2 cm = new CodilityIntelliMatic2();
        cm.populatePhoneCalls(CodilityIntelliMatic2.splitLog(log));
        assertEquals("400-234-090", cm.findLongestDuration());
    }

    @Test
    public void testCalculateTotalDurationPerPhone() {
        CodilityIntelliMatic2 cm = new CodilityIntelliMatic2();
        cm.populatePhoneCalls(CodilityIntelliMatic2.splitLog(log));
        assertEquals(301, cm.calculateTotalDurationPerPhone(cm.phoneCalls.get("701-080-080")));
        assertEquals(367, cm.calculateTotalDurationPerPhone(cm.phoneCalls.get("400-234-090")));
    }

    @Test
    public void testCalculateTotalPerPhone() {
        CodilityIntelliMatic2 cm = new CodilityIntelliMatic2();
        cm.populatePhoneCalls(CodilityIntelliMatic2.splitLog(log));
        assertEquals(900, cm.calculateTotalPerPhone(cm.phoneCalls.get("701-080-080")));
        assertEquals(951, cm.calculateTotalPerPhone(cm.phoneCalls.get("400-234-090")));
    }

    @Test
    public void testCalculteDuration() {
        assertEquals(67, CodilityIntelliMatic2.calculateDuration("00:01:07"));
        assertEquals(301, CodilityIntelliMatic2.calculateDuration("00:05:01"));
        assertEquals(300, CodilityIntelliMatic2.calculateDuration("00:05:00"));
    }

    @Test
    public void testPopulatePhoneCalls() {
        CodilityIntelliMatic2 cm = new CodilityIntelliMatic2();
        cm.populatePhoneCalls(CodilityIntelliMatic2.splitLog(log));
        assertEquals(67, CodilityIntelliMatic2.calculateDuration("00:01:07"));
    }

    @Test
    public void testCalculateCost() {
        CodilityIntelliMatic2.PhoneCall phoneCall = new CodilityIntelliMatic2.PhoneCall("aa", 67);

        assertEquals(201, phoneCall.calculateCost());

        CodilityIntelliMatic2.PhoneCall phoneCall2 = new CodilityIntelliMatic2.PhoneCall("aa", 300);

        assertEquals(750, phoneCall2.calculateCost());

        CodilityIntelliMatic2.PhoneCall phoneCall3 = new CodilityIntelliMatic2.PhoneCall("aa", 301);

        assertEquals(900, phoneCall3.calculateCost());
    }
}
