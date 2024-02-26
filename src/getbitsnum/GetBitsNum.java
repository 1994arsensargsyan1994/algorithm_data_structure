package getbitsnum;

import java.util.Arrays;
import java.util.Comparator;

public class GetBitsNum {

    private static final BitsComparator BITS_COMPARATOR = new BitsComparator();

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8};
        int[] ints = sortByBits(arr);
        System.out.println(ints);
    }

    public static int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed()
                .sorted(BITS_COMPARATOR)
                .mapToInt(a -> a)
                .toArray();
    }

    static class BitsComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            int i = getBitsNam(o1).compareTo(getBitsNam(o2));
            return i == 0 ? o1.compareTo(o2) : i;
        }

        Integer getBitsNam(int n) {
            int count = 0;
            while (n != 0) {
                count += (n & 1);
                n >>= 1;
            }
            return count;
        }
    }

}
