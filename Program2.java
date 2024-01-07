
import java.util.*;

class TelephoneSimulator {

    static Map<String, String> missedCalls;

    public TelephoneSimulator() {
        missedCalls = new LinkedHashMap<>();
    }

    public static void recordMissedCalls(String phoneNumber, String dailer) {
        if (dailer == null || dailer.equals("")) {
            dailer = "privateDailer";
        }
        missedCalls.put(phoneNumber, dailer);
    }

    public static void displayMissedCalls() {
        if (missedCalls.isEmpty()) {
            System.out.println("no missed calls");
        }
        for (Map.Entry<String, String> entry : missedCalls.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public void deleteMissedCalls(int number) {
        if (number <= 0 || missedCalls.isEmpty()) {
            System.out.println("no missed calls");
            return;
        }
        Iterator<Map.Entry<String, String>> iterator = missedCalls.entrySet().iterator();
        int count = 0;
        while (iterator.hasNext() && count < number) {
            iterator.next();
            iterator.remove();
            count++;
        }

    }
}

public class Program2 {

    public static void main(String[] args) {

        TelephoneSimulator simulator = new TelephoneSimulator();
        simulator.recordMissedCalls("8309455634", "jaswanth");
        simulator.recordMissedCalls("1123456789", "pranay");
        simulator.recordMissedCalls("9490136745", "ramu");
        simulator.recordMissedCalls("8118248974", "");

        simulator.displayMissedCalls();

        simulator.deleteMissedCalls(2);

        simulator.displayMissedCalls();
    }

}
