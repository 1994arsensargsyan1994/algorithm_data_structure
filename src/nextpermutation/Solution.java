package nextpermutation;

class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3,};
        nextPermutation(nums);
    }
    public static void nextPermutation(int[] nums) {
        if (nums.length < 1 || nums.length > 100) {
            throw new UnsupportedOperationException("Nums length must be greater or equal 1 and less equal 100");
        }
        int pivotIndex = 0;
        boolean hasNext = false;
        for (int j = nums.length - 2; j >= 0; j--) {
            if (nums[j] < nums[j + 1]) {
                hasNext = true;
                pivotIndex = j;
                break;
            }
        }

        if (!hasNext) {
            for (int i = 0, j = nums.length - 1; i <j; i++, j--) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            return;
        }
        for (int f = nums.length - 1; f > 0; f--) {
            if (nums[pivotIndex] < nums[f]) {
                int temp = nums[f];
                nums[f] = nums[pivotIndex];
                nums[pivotIndex] = temp;
                break;
            }
        }
        for (int i = pivotIndex + 1, j = nums.length - 1; i <j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}