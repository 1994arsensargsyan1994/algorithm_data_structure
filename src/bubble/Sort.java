package bubble;

import static utils.SortUtils.*;

public class Sort {
    public static void main(String[] args) {
        Comparable[] arr = {13, 12, 4, 15, 6, 8};
        Comparable[] sortedArray = sort(arr);
        println(sortedArray, System.out::println);
    }

    private static Comparable[] sort(Comparable[] arr) {
        int size = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < size; j++) {
                if (less(i,j+1)) {
                   swap(arr,i,j+1);
                } else {
                    size--;
                }
            }
        }
        return arr;
    }
}
