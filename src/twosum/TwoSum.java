package twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 3};
        int[] ints = twoSum(arr, 4);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    private static int[] twoSum(int[] array, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(array[0], 0);
        for (int i = 1; i < array.length; i++) {
            int val = target - array[i];

            if (map.containsKey(val)) {
                return new int[]{map.get(val), i};
            } else {
                map.put(array[i], i);
            }

        }
        return new int[]{};
    }
}
