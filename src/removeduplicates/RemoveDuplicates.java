package removeduplicates;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        int size = 0;

        for (int i = 0, j = 0; i < nums.length; i++, j++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            nums[size++] = nums[i];
        }
        return size;
    }
}
