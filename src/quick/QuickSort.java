package quick;

import utils.SortUtils;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {2, 5, 8, 1, 3, 6, 9};
        quickSort(nums, 0, nums.length - 1);
        SortUtils.println(nums, System.out::print);
    }

    private static int[] quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pivot = partition(nums, l, r);
            quickSort(nums, l, pivot - 1);
            quickSort(nums, pivot + 1, r);
        }
        return nums;
    }

    private static int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
