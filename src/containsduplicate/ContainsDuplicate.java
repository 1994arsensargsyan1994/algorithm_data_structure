package containsduplicate;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3,3, 4}));
    }

    public static boolean containsDuplicate(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)){
               return  true;
            }else {
                map.put(num,0);
            }
        }
        return false;
    }

}
