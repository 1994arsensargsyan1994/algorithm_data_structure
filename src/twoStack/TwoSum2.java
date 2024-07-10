package twoStack;

// for sorted array (two pointer)
public final class TwoSum2 {

    public static void main(String[] args) {
        int[] ints = twoSum2(new int[]{1, 3, 4, 5, 7, 11}, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }


    public static int [] twoSum2(int [] array,int target){
        int l = 0;
        int r = array.length -1;
        while (l <= r){
            if (array[l] + array[r] > target){
                r--;
            }else if (array[l]+ array[r] < target){
                l++;
            }else {
                return new int[]{l+1,r+1};
            }
        }
        return new int[]{};
    }

}