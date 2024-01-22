package searchInsertposition;

class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int i = searchInsert(nums, 2);
        System.out.println(i);

    }

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int hi = nums.length - 1;
        while (low <= hi) {
            int mid = low + (hi - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            }
        }
        return low;
    }
}