package binar;

public class Search {

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 10, 48, 90, 100, 112, 114, 121};
        int search = searchRecursive(arr, 0, arr.length, 5);
        System.out.println(search);
    }

    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else
                right = mid - 1;
        }

        return -1;
    }

    public static int searchRecursive(int[] arr, int l, int r, int target) {
        int mid = (r + l) / 2;

        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            return searchRecursive(arr, mid + 1, r, target);
        } else {
            return searchRecursive(arr, l, r - 1, target);
        }
    }
}
