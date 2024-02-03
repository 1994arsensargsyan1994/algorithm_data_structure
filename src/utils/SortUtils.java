package utils;

import java.util.function.Consumer;

public final class SortUtils {

    public static void println(int[] arr, Consumer<Integer> consumer) {
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

    private SortUtils() {
        throw new UnsupportedOperationException();
    }
}
