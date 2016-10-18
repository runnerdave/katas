package net.runnerdave.elevator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by e67997 on 18/10/2016.
 */
public class ElevatorController {
    private Queue<Person> queue;
    private boolean chatty;

    public ElevatorController(boolean chatty) {
        this.chatty = chatty;
        queue = new ArrayDeque<>();
    }

    private void fillElevator(Elevator e) {
        while(!queue.isEmpty() && e.fitNext(queue.peek())) {
            e.addPerson();
            Person p = queue.remove();
            e.setWeight(e.getWeight() + p.weight);
            e.addToPassengerFloorList(p, p.floor);
        }
    }

    private int makeTrips(Elevator e, int M) {
        int numberOfStops = 0;
        for (int i = 1; i <= M; i++) {
            List<Person> stop = e.getPassengerListByFloor(i);
            if (stop != null) {
                if (chatty) {
                    System.out.println("=== Stopping in level: " + i);
                    System.out.println("        === Dropping " + stop.size() + " people");
                }
                numberOfStops ++;
                for (int j = 0; j < stop.size(); j++) {
                    e.removePerson();
                }
            }
        }
        return numberOfStops;
    }

    private void fillQueue(int[] A, int[] B) {
        for (int i = 0; i < A.length; i++) {
            Person p = new Person(A[i], B[i]);
            queue.add(p);
        }
    }

    public int transportAllPeople(int[] A, int[] B, int M, int X, int Y) {
        int numberOfStops = 0;
        fillQueue(A, B);

        while (!queue.isEmpty()) {
            Elevator e = new Elevator(X, Y);
            fillElevator(e);
            if (chatty) {
                System.out.println("====Filling elevator in Ground floor");
                System.out.println(e.toString());
            }
            numberOfStops += makeTrips(e, M);
            numberOfStops++;
            e = null;
        }

        return numberOfStops;
    }
}
