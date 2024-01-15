package selection;

import static utils.SortUtils.println;

public class Sort {

    public static void main(String[] args) {
        int[] arr = {13, 12, 4, 15, 6, 8};
        int[] sortedArray = sort(arr);
        println(sortedArray, System.out::println);
    }

    private static int[] sort(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {

                if (arr[i] > arr[j]) {
                    min = arr[j];
                    arr[j] = arr[i];
                    arr[i] = min;
                }
            }
        }
        return arr;
    }
}
