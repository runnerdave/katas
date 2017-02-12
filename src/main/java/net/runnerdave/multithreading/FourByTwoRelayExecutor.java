package net.runnerdave.multithreading;

import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * -Running race of 400 meters.
 * -Five thread groups, each with a country name
 * -Two runners per group, ten in total
 * -Each runner runs 200 meters
 * -Print the winner and all the groups should complete the race
 * -Print the time taken by each group to complete the race and highlight the winners time.
 * <p>
 * Created by runnerdave
 */
public class FourByTwoRelayExecutor {

    public static Map<String, Runner> runnerAnalysisMap = new HashMap();

    public static void main(String... args) throws InterruptedException, BrokenBarrierException {
        Map<String, List<Runner>> allTeams;

        CountDownLatch batonGER = new CountDownLatch(0);
        CountDownLatch batonUSA = new CountDownLatch(0);
        CountDownLatch batonJAM = new CountDownLatch(0);
        CountDownLatch batonTT = new CountDownLatch(0);
        CountDownLatch batonNAM = new CountDownLatch(0);

        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(6);
            Runner gerRunner1 = new FirstRunner(batonGER, "Lars - GER");
            Runner gerRunner2 = new SecondRunner(batonGER, "Bodo - GER");
            List<Runner> gerRunners = new ArrayList<Runner>(Arrays.asList(gerRunner1, gerRunner2));
            runnerAnalysisMap.put(gerRunner1.getName(), gerRunner1);
            runnerAnalysisMap.put(gerRunner2.getName(), gerRunner2);

            Runner usaRunner1 = new FirstRunner(batonUSA, "Carl - USA");
            Runner usaRunner2 = new SecondRunner(batonUSA, "Michael - USA");
            List<Runner> usaRunners = new ArrayList<Runner>(Arrays.asList(usaRunner1, usaRunner2));
            runnerAnalysisMap.put(usaRunner1.getName(), usaRunner1);
            runnerAnalysisMap.put(usaRunner2.getName(), usaRunner2);

            Runner jamRunner1 = new FirstRunner(batonJAM, "Usain - JAM");
            Runner jamRunner2 = new SecondRunner(batonJAM, "Asafa - JAM");
            List<Runner> jamRunners = new ArrayList<Runner>(Arrays.asList(jamRunner1, jamRunner2));
            runnerAnalysisMap.put(jamRunner1.getName(), jamRunner1);
            runnerAnalysisMap.put(jamRunner2.getName(), jamRunner2);

            Runner ttRunner1 = new FirstRunner(batonTT, "Ato - TT");
            Runner ttRunner2 = new SecondRunner(batonTT, "Richard - TT");
            List<Runner> ttRunners = new ArrayList<Runner>(Arrays.asList(ttRunner1, ttRunner2));
            runnerAnalysisMap.put(ttRunner1.getName(), ttRunner1);
            runnerAnalysisMap.put(ttRunner2.getName(), ttRunner2);

            Runner namRunner1 = new FirstRunner(batonNAM, "Frankie - NAM");
            Runner namRunner2 = new SecondRunner(batonNAM, "Daniel - NAM");
            List<Runner> namRunners = new ArrayList<Runner>(Arrays.asList(namRunner1, namRunner2));
            runnerAnalysisMap.put(namRunner1.getName(), namRunner1);
            runnerAnalysisMap.put(namRunner2.getName(), namRunner2);

            allTeams = new HashMap<>();
            allTeams.put("GER", gerRunners);
            allTeams.put("USA", usaRunners);
            allTeams.put("JAM", jamRunners);
            allTeams.put("TT", ttRunners);
            allTeams.put("NAM", namRunners);

            //Start the race!
            service.execute(gerRunner1);
            service.execute(usaRunner1);
            service.execute(jamRunner1);
            service.execute(ttRunner1);
            service.execute(namRunner1);

            //pass the batons!
            service.execute(gerRunner2);
            service.execute(usaRunner2);
            service.execute(jamRunner2);
            service.execute(ttRunner2);
            service.execute(namRunner2);

            try {
                Thread.sleep(1000);
            } catch(InterruptedException ie) {
                //suppress this exception
            }

            Map<String, List<Runner>> result = new LinkedHashMap<>();

            allTeams.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(byTotalTime))
                    .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));


            System.out.println("====total times====");
            result.forEach((k,v)->{
                System.out.println(k + ":");
                System.out.println(printTeamTimeDetails(v));
            });


        } finally {
            if (service != null) service.shutdown();
        }
    }

    static Comparator<List<Runner>> byTotalTime = (l1, l2) -> {
        if ((getTotalTeamTime(l1)) > (getTotalTeamTime(l2))) {
            return 1;
        } else {
            return -1;
        }
    };

    static long getTotalTeamTime(List<Runner> list) {
        return list.stream().map(r->r.getTotalTime()).reduce((a,b)->a+b).get();
    }

    static String printTeamTimeDetails(List<Runner> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(getTotalTeamTime(list));
        sb.append("(").append(list).append(")");
        return sb.toString();
    }
}

abstract class Runner implements Runnable {

    protected final CountDownLatch baton;
    private final String name;
    private long totalTime;
    private long startTime;
    private long endTime;

    @Override
    public String toString() {
        return this.name + ":" + totalTime;
    }

    long getTotalTime() {
        return totalTime;
    }

    long getStartTime() {
        return startTime;
    }

    long getEndTime() {
        return endTime;
    }

    Runner(CountDownLatch baton, String name) {
        this.baton = baton;
        this.name = name;
    }

    public void race() {
        long startTime = System.nanoTime();
        System.out.println(name + " started at: " + startTime);
        for (int distance = 1; distance <= 200; distance++) {

            if (distance % 50 == 0) {
                 System.out.println("Distance covered by "
                 + name + " is: " + distance + " meters");
            }
        }
        long endTime = System.nanoTime();
        System.out.println(name + " finished at: " + endTime);
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalTime = (endTime - startTime);
        System.out.println("Time taken by " + name + " is: " + totalTime);
    }

    @Override
    public abstract void run();

    public String getName() {
        return name;
    }
}

class FirstRunner extends Runner {

    public FirstRunner(CountDownLatch baton, String name) {
        super(baton, name);
    }

    public void run() {
        this.race();
        baton.countDown();
    }
}

class SecondRunner extends Runner {
    public SecondRunner(CountDownLatch baton, String name) {
        super(baton, name);
    }

    public void run() {
        try {
            baton.await();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.race();
    }

}


