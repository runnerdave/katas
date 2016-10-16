package net.runnerdave;

import java.util.*;

/**
 * Created by runnerdave on 16/10/16.
 */
public class CodilityReal {


    Queue<Person> queue;

    public CodilityReal() {
        queue = new ArrayDeque<>();
    }

    public static int solution(int[] ints) {
        return 0;
    }

    public int solution(int[] A, int[] B, int M, int X, int Y) {
        int numberOfStops = 0;
        fillQueue(A, B);

        while (!queue.isEmpty()) {
            Elevator e = new Elevator(X, Y);
            fillElevator(e);
            numberOfStops += makeTrip(e, M);
            numberOfStops++;
            e = null;
        }

        return numberOfStops;
    }

    private int makeTrip(Elevator e, int M) {
        int numberOfStops = 0;
        for (int i = 1; i <= M; i++) {
            List<Person> stop = e.peopleMap.get(i);
            if (stop != null) {
                numberOfStops ++;
            }
        }
        return numberOfStops;
    }

    private void fillElevator(Elevator e) {
        while(!queue.isEmpty() && fitNext(queue.peek(), e)) {
            e.numberOfPeople++;
            Person p = queue.remove();
            e.weight += p.weight;
            List<Person> floorList = e.peopleMap.get(p.floor);
            if(floorList == null) {
                floorList = new ArrayList<>();
                floorList.add(p);
                e.peopleMap.put(p.floor, floorList);
            } else {
                floorList.add(p);
            }
        }
    }

    //check to see if elevator can take one more person
    boolean fitNext(Person p, Elevator e){
        return e.maxCapacity >= (e.numberOfPeople + 1) && e.weightLimit >= (e.weight + p.weight);
    }



    class Elevator {
        private int maxCapacity;
        private int weightLimit;
        int numberOfPeople;
        int weight;
        Map<Integer, List<Person>> peopleMap = new HashMap<>();
        public Elevator(int maxCapacity, int weightLimit) {
            this.maxCapacity = maxCapacity;
            this.weightLimit = weightLimit;
        }
    }

    class Person {
        int weight;
        int floor;
        public Person(int weight, int floor) {
            this.weight = weight;
            this.floor = floor;
        }
    }



    void fillQueue(int[] A, int[] B) {
        for (int i = 0; i < A.length; i++) {
            Person p = new Person(A[i], B[i]);
            queue.add(p);
        }
    }
}
