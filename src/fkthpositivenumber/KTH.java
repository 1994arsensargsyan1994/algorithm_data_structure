package fkthpositivenumber;

import java.util.HashSet;
import java.util.Set;

public class KTH {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> integers = new HashSet<>();
        for (int j : arr) {
            integers.add(j);
        }
        int size = arr[arr.length - 1] + k;
        int val = 0;
        for (int i = 1; i <= size; i++) {
            if (!integers.contains(i) && k != 0) {
                val = i;
                k--;
            }
        }
        return val;
    }
}
