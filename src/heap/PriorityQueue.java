package heap;

public class PriorityQueue {

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.push(15);
        priorityQueue.push(16);
        priorityQueue.push(14);
        priorityQueue.push(9);
        priorityQueue.push(28);
        priorityQueue.push(1);

        System.out.println(priorityQueue.top());
        System.out.println(priorityQueue.pop());
        System.out.println(priorityQueue.top());
    }

    private int[] storage;
    private int size;

    public PriorityQueue() {
        this.storage = new int[10];
        this.size = 0;
    }

    public void push(int element) {
        if (size == storage.length) {
            growSize();
        }
        storage[size++] = element;
        build(storage, size);
    }

    public int top() {
        return storage[0];
    }

    public int pop() {
        int tmp = storage[0];
        storage[0] = storage[size - 1];
        storage[size - 1] = tmp;
        size--;
        maxHeapify(storage, size, 0);
        return tmp;
    }

    private void build(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
    }

    private void maxHeapify(int[] arr, int size, int i) {
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

    private int getLeft(int i) {
        return 2 * i + 1;
    }

    private int getRight(int i) {
        return 2 * i + 2;
    }

    private void growSize() {
        int[] temp = new int[storage.length + (storage.length / 2)];
        System.arraycopy(storage, 0, temp, 0, size);
        storage = temp;
    }
}
