package selection;

import static utils.SortUtils.*;

public class Sort {

    public static void main(String[] args) {
        Comparable[] arr = {8, 4, 6, 7, 15, 1, 3, 22, 5};
        Comparable[] sortedArray = sort(arr);
        println(sortedArray, System.out::println);
    }

    private static Comparable[] sort(Comparable[] arr) {


        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
        return arr;
    }
}
