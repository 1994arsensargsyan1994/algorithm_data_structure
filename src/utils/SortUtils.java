package utils;

import java.util.function.Consumer;
import java.util.function.Supplier;

public final class SortUtils {

    public static void println(int[] arr, Consumer<Integer> consumer){
        for (int i = 0; i < arr.length; i++) {
            consumer.accept(arr[i]);
        }
    }

    private SortUtils(){
        throw new UnsupportedOperationException();
    }
}
