package inter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example {


    public static void main(String[] args) {
        boolean a = isPalindrome(111);
        System.out.println(a);

    }

    private static boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int num = 0;
        while (x > num) {
            num = num * 10 + x % 10;
            x /= 10;
        }

        return x == num || x == num / 10;

    }

    public static int removeElement(int[] nums, int val) {
        int count = 0;


        for(int num : nums){
            if(num != val){
                nums[count ++] = num;
            }
        }

        return count;


    }

    public static int[] sortArray(int[] nums) {

        int N = nums.length;
        int M = 0;

        for(int i = 0;i < N;i++){
            M =  Math.max(M,nums[i]);
        }
        int [] couting = new int[M+1];
        for(int i = 0;i < N;i++){
            couting[nums[i]]++;
        }

        for(int i = 1;i <= M;i++){
            couting[i] = couting[i] + couting[i -1];
        }

        int result [] = new int  [N];
        for(int i = N-1;i >= 0;i--){
            result[couting[nums[i]] -1] = nums[i];
            couting[nums[i]] --;
        }
        return result;
    }

    public static int romanToInt(String s) {
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        for(int i = 0; i+1 < s.length();++i){

            if(map.get(s.charAt(i)) < map.get(s.charAt(i +1))){
                res -= map.get(s.charAt(i));
            }else {
                res += map.get(s.charAt(i));
            }
        }
        return res += map.get(s.charAt(s.length() -1));

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        for (int i = 0; i < strs[0].length(); ++i)
            for (int j = 1; j < strs.length; ++j)
                if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i))
                    return strs[0].substring(0, i);

        return strs[0];
    }

    private static final Map<Character, char[]> KEYBOARD = Map.of(
            '2', "abc".toCharArray(),
            '3', "def".toCharArray(),
            '4', "ghi".toCharArray(),
            '5', "jkl".toCharArray(),
            '6', "mno".toCharArray(),
            '7', "pqrs".toCharArray(),
            '8', "tuv".toCharArray(),
            '9', "wxyz".toCharArray()
    );

    public static List<String> letterCombinationsOfPhoneNumber(String digits) {
        List<String> res = new ArrayList<>();
        dfs(new StringBuilder(), res, digits.toCharArray());
        return res;
    }

    private static void dfs(StringBuilder path, List<String> res, char[] digits) {
        if (path.length() == digits.length) {
            res.add(path.toString());
            return;
        }
        char next_digit = digits[path.length()];
        for (char letter : KEYBOARD.get(next_digit)) {
            path.append(letter);
            dfs(path, res, digits);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
