package net.runnerdave;

import java.util.*;

/**
 * Created by runnerdave on 24/01/17.
 */
public class CodilityIntelliMatic2 {



    public Map<String, List<PhoneCall>> phoneCalls = new HashMap<>();

    public int solution(String S) {
        populatePhoneCalls(splitLog(S));
        return calculateTotal();
    }

    public void populatePhoneCalls(String[] logEntries) {
        for (String entry: logEntries
             ) {
            String[] log = entry.split(",");
            int duration = calculateDuration(log[0]);
            String phoneNumber = log[1];
            PhoneCall call = new PhoneCall(phoneNumber, duration);
            List<PhoneCall> calls = phoneCalls.get(phoneNumber);
            if (calls != null ) {
                calls.add(call);
            } else {
                calls = new ArrayList<>();
                calls.add(call);
                phoneCalls.put(phoneNumber, calls);
            }
        }
    }

    public int calculateTotal() {
        int total = 0;
        String longestDurationPhone = findLongestDuration();
        for (Map.Entry<String, List<PhoneCall>> entry : phoneCalls.entrySet()) {
            if(!entry.getKey().equalsIgnoreCase(longestDurationPhone)){
                total += calculateTotalPerPhone(entry.getValue());
            }
        }
        return total;
    }

    public String findLongestDuration() {
        String phone = "";
        int duration = 0;
        for (Map.Entry<String, List<PhoneCall>> entry : phoneCalls.entrySet()) {

            if(duration < calculateTotalDurationPerPhone(entry.getValue())) {
                duration = calculateTotalDurationPerPhone(entry.getValue());
                phone = entry.getKey();
            }
        }
        return phone;
    }

    public int calculateTotalDurationPerPhone(List<PhoneCall> phoneCalls) {
        int total =0;
        for (PhoneCall ph: phoneCalls
                ) {
            total += ph.duration;
        }
        return total;
    }

    public int calculateTotalPerPhone(List<PhoneCall> phoneCalls) {
        int total =0;
        for (PhoneCall ph: phoneCalls
             ) {
            total += ph.calculateCost();
        }
        return total;
    }

    static class PhoneCall {
        String number;
        int duration;

        PhoneCall(String number, int duration){
            this.number = number;
            this.duration = duration;
        }

        public int calculateCost() {
            if (duration < 300) {
                return duration*3;
            } else {
                if (duration%60 == 0) {
                    return duration/60*150;
                } else {
                    return duration/60*150 + 150;
                }
            }
        }


    }

    public static int calculateDuration(String durationString) {
        int duration = 0;
        String[] values = durationString.split(":");
        duration = Integer.valueOf(values[0].trim())*3600
                + Integer.valueOf(values[1].trim())*60
                + Integer.valueOf(values[2].trim());
        return duration;
    }

    public static String[] splitLog(String log) {
        return log.split("\\r\\n|\\n|\\r");
    }

}
