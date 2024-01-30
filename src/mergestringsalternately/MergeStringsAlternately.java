package mergestringsalternately;

public class MergeStringsAlternately {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
    }

    public static String mergeAlternately(String word1, String word2) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < word1.length() || i < word2.length(); i++) {

            builder.append(word1.charAt(i)).append(word2.charAt(i));

        }
        return builder.toString();

    }
}
