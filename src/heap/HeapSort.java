package heap;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 4, 7 };

        HeapSort sort = new HeapSort();
        sort.sort(arr);

        for (int i : arr) {
            System.out.println(i);
        }

    }

    public void sort(int[] arr) {
        int n = arr.length;
        build(arr, n);
        sort(arr, n);

    }

    private  void sort(int[] arr, int n) {
        for (int i = n - 1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            maxHeapify(arr, i, 0);
        }
    }

    private  void build(int[] arr, int n) {
        for (int i = n / 2 - 1; i >=0; i--) {
            maxHeapify(arr, n, i);
        }
    }

    private  void maxHeapify(int[] arr, int size, int i) {
        int largest = i;
        int left = getLeft(i);
        int right = getRight(i);
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            maxHeapify(arr, size, largest);
        }
    }

    private  int getLeft(int i) {
        return 2 * i  + 1;
    }

    private  int getRight(int i) {
        return 2 * i + 2;
    }
}
