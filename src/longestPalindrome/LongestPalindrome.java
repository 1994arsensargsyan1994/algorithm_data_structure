package longestPalindrome;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestPalindrome {

    public static void main(String[] args) {
        int i = longestPalindrome("bananas");
        System.out.println(i);
    }

    public static int longestPalindrome(String s) {
        if(s.length() == 1) return 1;

        Map<Character, Long> counting = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int ans = counting
                .values()
                .stream()
                .mapToInt(freq -> Math.toIntExact(freq % 2 == 0 ? freq : freq - 1))
                .sum();

        boolean hasOddCount = counting
                .values()
                .stream()
                .anyMatch(freq -> freq % 2 == 1);

        return ans + (hasOddCount ? 1 : 0);
    }
}
