package partitiondisjoint;

import java.util.LinkedList;

public class PartitionDisjoint {
    public static void main(String[] args) {
        int[] a = {5, 0, 3, 8, 6};
        System.out.println(partitionDisjoint(a));
    }

    public static int partitionDisjoint(int[] nums) {

        LinkedList<Integer> integers = new LinkedList<>();

        int min = nums[nums.length - 1];
        integers.addFirst(min);
        for (int i = nums.length - 1; i > 0; i--) {
            min = Math.min(nums[i], min);
            integers.addFirst(min);
        }
        int maxLeft = 0;

        for (int i = 1; i <= nums.length - 1; ++i) {
            maxLeft = Math.max(maxLeft, nums[i - 1]);

            if (maxLeft <= integers.get(i)) {
                return i;
            }
        }
        return -1;
    }
}
