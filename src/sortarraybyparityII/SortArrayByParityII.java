package sortarraybyparityII;

public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2) == 0 && (nums[i] % 2) == 0) {
                continue;
            }
            else if ((i % 2) != 0 && (nums[i] % 2) != 0) {
                continue;
            }else {
                int temp = nums[i];
                nums[i] = nums[i +1];
                nums[i+1] = temp;
            }
        }
        return nums;
    }
}
