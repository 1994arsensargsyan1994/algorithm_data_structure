package findRestaurant;

import java.util.HashMap;
import java.util.Map;

public class FindRestaurant {

    public static void main(String[] args) {
        String[] list1 = new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = new String[]{"KFC","Shogun","Burger King"};

        String[] restaurant = findRestaurant(list1, list2);
        System.out.println(restaurant);
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Pair> minIndexes = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            minIndexes.put(list1[i],new Pair(Boolean.FALSE,i));
        }
      int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (minIndexes.containsKey(list2[i])) {
                int val = minIndexes.get(list2[i]).getSecond() + i;
                minIndexes.put(list2[i],new Pair(Boolean.TRUE, val));
                if (val < min){
                    min = val;
                }
            }
        }
        int constMin = min;
        minIndexes.values().removeIf(rm -> rm.getFirst().equals(Boolean.FALSE) || rm.getSecond() > constMin);

        return minIndexes.keySet().toArray(new String[0]);

    }

    static class Pair {
        private final Boolean first;
        private final Integer second;

        private Pair(Boolean first, Integer second) {
            this.first = first;
            this.second = second;
        }

        static Pair of(Boolean first, Integer second){
            return new Pair(first,second);
        }

        public Boolean getFirst() {
            return first;
        }

        public Integer getSecond() {
            return second;
        }
    }


}
