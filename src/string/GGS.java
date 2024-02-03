package string;

public class GGS {

    public static void main(String[] args) {
        String s = largestMerge("abcabc", "abdcaba");
        System.out.println(s);
    }

    public static String largestMerge(String word1, String word2) {

        StringBuilder builder = new StringBuilder();
        if (word1.isEmpty() || word2.isEmpty()) {
            return word1 + word2;
        }

        if (word1.compareTo(word2) == 0) {
            return word1 + word2;
        }
        int i = 0;
        int j = 0;
        while (i < word1.length() && j < word2.length()) {

            if (word1.substring(i).compareTo(word2.substring(j)) > 0) {
                builder.append(word1.charAt(i));
                i++;
            } else {
                builder.append(word2.charAt(j));
                j++;
            }
        }

        while (i < word1.length()) {
            builder.append(word1.charAt(i));
            i++;
        }

        while (j < word2.length()) {
            builder.append(word2.charAt(j));
            j++;
        }

        return builder.toString();
    }
}
