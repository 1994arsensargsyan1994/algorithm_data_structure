package insertion;

import static utils.SortUtils.println;

public class Sort {

    public static void main(String[] args) {
        int[] arr = {13, 12, 4, 15, 6, 8};
        sort(arr);
        println(arr, System.out::println);
    }

    private static int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int temp = arr[i];
            while (j >= 0 && arr[j] > temp) {

                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = temp;
        }
        return arr;
    }
}
