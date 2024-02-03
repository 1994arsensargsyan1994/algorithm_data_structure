package countingsort;

import utils.SortUtils;

public class CountSort {

    public int[] sort(int[] input) {
        int length = input.length;

        int max = SortUtils.max(input);
        if (max == -1) {
            throw new IllegalStateException("Can not find max element");
        }
        int[] countArray = new int[max + 1];

        for (int j : input) {
            countArray[j]++;
        }

        for (int i = 1; i <= max; i++) {
            countArray[i] += countArray[i - 1];
        }

        int[] outputArray = new int[length];

        for (int i = length - 1; i >= 0; i--) {
            outputArray[countArray[input[i]] - 1] = input[i];
            countArray[input[i]]--;
        }

        return outputArray;
    }
}
