package findGCD;

public class FindGCD {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int divisor = 1;
        for (int i = 0;i <= nums.length-1; i ++ ){
            if(nums[i] > max){
                max = nums[i];
            }
            if(nums[i] < min){
                min = nums[i];
            }
        }

        for(int i = 1;i <=min;i++){

            if (min %  i == 0 && max  %  i == 0){
                divisor =i;
            }
        }

        return divisor;
    }
}
