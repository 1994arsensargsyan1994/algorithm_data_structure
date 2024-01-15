package bubble;

import static utils.SortUtils.println;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {13, 12, 4, 15, 6, 8};
        int[] sortedArray = sort(arr);
        println(sortedArray, System.out::println);
    }

    private static int[] sort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } else {
                    size--;
                }
            }
        }
        return arr;
    }
}
