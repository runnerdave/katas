package net.runnerdave.multithreading;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;

import static org.junit.Assert.*;

/**
 * Created by runnerdave on 12/02/17.
 */
public class FourByTwoRelayExecutorTest {

    @Test
    public void testMain() throws BrokenBarrierException, InterruptedException {
        FourByTwoRelayExecutor.main("   ");
        //perform analysis
        assertEquals(FourByTwoRelayExecutor.runnerAnalysisMap.size(), 10);
        List<Runner> starters = new ArrayList<>(5);
        List<Runner> finishers = new ArrayList<>(5);
        Map<String, Runner> anMap = FourByTwoRelayExecutor.runnerAnalysisMap;
        anMap.forEach((k, v) -> {
            if (v instanceof FirstRunner) {
                starters.add(v);
            }
            if (v instanceof SecondRunner) {
                finishers.add(v);
            }
        });
        assertEquals(starters.size(), 5);
        assertEquals(finishers.size(), 5);
        for (Runner s : starters
                ) {
            for (Runner f : finishers
                    ) {
                assertEquals(true, s.getStartTime() < f.getEndTime());
            }
        }
        System.out.println("baton passing times:");
        System.out.println("GER:" + (anMap.get("Bodo - GER").getStartTime() - anMap.get("Lars - GER").getEndTime()));
        System.out.println("USA: " + (anMap.get("Michael - USA").getStartTime() - anMap.get("Carl - USA").getEndTime()));
        System.out.println("JAM:" + (anMap.get("Asafa - JAM").getStartTime() - anMap.get("Usain - JAM").getEndTime()));
        System.out.println("TT:" + (anMap.get("Richard - TT").getStartTime() - anMap.get("Ato - TT").getEndTime()));
        System.out.println("NAM:" + (anMap.get("Daniel - NAM").getStartTime() - anMap.get("Frankie - NAM").getEndTime()));
    }

}