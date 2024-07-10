package insertion;

import static utils.SortUtils.*;

public class Sort {

    public static void main(String[] args) {
        Comparable[] arr = {8, 4, 6, 7, 15, 1, 3, 22, 5};
        sort(arr);
        println(arr, System.out::println);
    }

    private static Comparable[] sort(Comparable[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(arr[j], arr[j - 1])) {
                    swap(arr, j, j - 1);
                } else break;
            }
        }
        return arr;

    }
}
