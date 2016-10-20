package net.runnerdave.elevator;

import net.runnerdave.elevator.ElevatorController;

/**
 * Created by e67997 on 18/10/2016.
 */
public class ElevatorRunner {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Welcome to 440 Elizabeth st. Melbourne");
        ElevatorController ec = new ElevatorController(true);
        int totalStops = 0;
        int totalRuns = 150;
        while (totalRuns > 0) {
            System.out.println("run : " + totalRuns);
            totalStops = ec.transportAllPeople(new int[]{40, 40, 100, 80, 20}, new int[]{3, 3, 2, 2, 3}, 3, 5, 200);
            System.out.println("total number of stops: " + totalStops);
            Thread.sleep(1000); // 1 SECOND
            Object[] objects;
            if (totalRuns == 150) {
                objects = new Object[10000000];
            }

            if (totalRuns == 100) {
                objects = null;
            }

            if (totalRuns == 90) {
                Integer count = 0;
                for(long x=0;x<Integer.MAX_VALUE ;x++){
                    count +=1;
                }
                System.out.println("count: " + count);
            }

            totalRuns--;
        }
    }


}
