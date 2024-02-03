package sortcolors;

import countingsort.CountSort;
import utils.SortUtils;

public class SortColors {
    public static void main(String[] args) {
        int[] ints = new int[]{2, 0, 2, 1, 1, 0};
        int[] result = sortColors(ints);
        SortUtils.println(result, System.out::print);
    }

    public static int[] sortColors(int[] nums) {
        CountSort countSort = new CountSort();
        return countSort.sort(nums);
    }
}
