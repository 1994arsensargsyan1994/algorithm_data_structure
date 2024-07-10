package utils;

import java.util.function.Consumer;

public final class SortUtils {

    public static void println(Comparable[] arr, Consumer<Comparable> consumer) {
        for (int i = 0; i < arr.length; i++) {
            consumer.accept(arr[i]);
        }
    }

    public static int max(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;

    }

    public static void swap(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private SortUtils() {
        throw new UnsupportedOperationException();
    }
}
