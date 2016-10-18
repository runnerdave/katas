package net.runnerdave.elevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by e67997 on 18/10/2016.
 */
public class Elevator {
    private int maxCapacity;
    private int weightLimit;
    private int numberOfPeople;
    private int weight;

    private Map<Integer, List<Person>> passengerMap;

    public Elevator(int maxCapacity, int weightLimit) {
        this.maxCapacity = maxCapacity;
        this.weightLimit = weightLimit;
        passengerMap = new HashMap<>();
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }


    public void addPerson() {
        this.numberOfPeople++;
    }

    public void removePerson() {
        this.numberOfPeople--;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Person> getPassengerListByFloor(Integer floor) {
        List<Person> floorList = passengerMap.get(floor);
        return floorList;
    }

    public void addToPassengerFloorList(Person p, Integer floor) {
        List<Person> floorList = this.passengerMap.get(floor);
        if (floorList != null) {
            floorList.add(p);
        } else {
            floorList = new ArrayList<>();
            floorList.add(p);
            this.passengerMap.put(floor, floorList);
        }
    }

    //check to see if elevator can take one more person
    boolean fitNext(Person p) {
        return this.maxCapacity >= (this.numberOfPeople + 1) && this.weightLimit >= (this.weight + p.weight);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("         == Elevator information:").append("\n       Number of people: ")
                .append(this.getNumberOfPeople())
                .append("\n       Floors to go:").append(this.passengerMap.keySet());
        return info.toString();
    }
}
