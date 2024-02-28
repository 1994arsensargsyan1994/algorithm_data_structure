package map;

import java.util.UUID;

public class Executor {
    public static void main(String[] args) {
        put();
        putFailed();
        //TODO add more test cases
    }

    private static void put() {
        String value = UUID.randomUUID().toString();
        CustomMap<Integer, String> forTest = new CustomMap<>();
        forTest.put(1, value);

        if (forTest.get(1).equals(value)) {
            System.out.println("Put Test success");
        } else {
            System.out.println("Put Test failed");
        }
    }

    private static void putFailed() {
        String value = UUID.randomUUID().toString();
        String incorrectValue = UUID.randomUUID().toString();
        CustomMap<Integer, String> forTest = new CustomMap<>();
        forTest.put(1, value);

        if (forTest.get(1).equals(incorrectValue)) {
            System.out.println("Put Failed Test failed");
        } else {
            System.out.println("Put Failed Test success");
        }
    }
}
