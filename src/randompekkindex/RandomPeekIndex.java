package randompekkindex;

import java.util.*;

public class RandomPeekIndex {

    public static void main(String[] args) {
        RandomPeekIndex randomPeekIndex = new RandomPeekIndex(new int[]{1, 2, 3, 3, 3});
        int pick = randomPeekIndex.pick(3);
        System.out.println(pick);
    }

    private Map<Integer, List<Integer>> integerMap = new HashMap<>();

    public RandomPeekIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            if (integerMap.containsKey(nums[i])) {
                List<Integer> integers = integerMap.get(nums[i]);
                integers.add(i);
                integerMap.put(nums[i], integers);
            } else {
                ArrayList<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                integerMap.put(nums[i], indexes);
            }
        }


    }

    public int pick(int target) {
        List<Integer> integers = integerMap.get(target);
        if (!integers.isEmpty()){
           return integers.get(new Random().nextInt(0,integers.size()));
        }
       return  -1;
    }
}
