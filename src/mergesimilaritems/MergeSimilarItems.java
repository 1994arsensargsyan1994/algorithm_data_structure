package mergesimilaritems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MergeSimilarItems {

    public static void main(String[] args) {
        List<List<Integer>> result = mergeSimilarItems(
                new int[][]{{1, 1}, {4, 5}, {3, 8}}, new int[][]{{3, 1}, {1, 5}}
        );
        System.out.println(result);
    }

    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> resultMap = new TreeMap<>();
        for (int[] ints : items1) {
            resultMap.put(ints[0], ints[1]);
        }

        for (int[] ints : items2) {
            if (resultMap.containsKey(ints[0])) {
                resultMap.put(ints[0], resultMap.get(ints[0]) + ints[1]);
            } else {
                resultMap.put(ints[0], ints[1]);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        resultMap.forEach((key, val) -> result.add(List.of(key, val)));

        return result;
    }
}
