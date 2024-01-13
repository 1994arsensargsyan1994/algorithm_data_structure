package utils;

public final class SortUtils {

    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private SortUtils(){
        throw new UnsupportedOperationException();
    }
}
