package longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String val = "abcabcbb";
        int res = lengthOfLongestSubstring(val);
    }

    public static int lengthOfLongestSubstring(String s) {

        int aPointer = 0;
        int bPointer = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();

        while (bPointer < s.length()) {
            if (!set.contains(s.charAt(bPointer))) {
                set.add(s.charAt(bPointer));
                bPointer++;
                res = Math.max(set.size(), res);
            } else {
                set.remove(s.charAt(aPointer));
                aPointer++;
            }
        }

        return res;
    }
}
