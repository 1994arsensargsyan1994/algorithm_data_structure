package queue;

public class Queue {
    private int[] arr;
    private int size;
    private int front;
    private int back;

    public Queue(int size) {
        this.size = size;
        this.arr = new int[size];
        this.front = -1;
        this.back = -1;
    }

    public void push(int elm) {
        if (isFull()) {
            throw new IllegalStateException("Fully");
        } else if (front == -1 && back == -1) {
            front = back = 0;
            arr[back] = elm;
        } else {
            arr[++back] = elm;
        }
        size++;
    }

    public int pop() {
        if (isEmpty()){
            throw  new UnsupportedOperationException("is Empty");
        }
        int elm = arr[front++];
        size--;
        return elm;
    }

    public boolean isFull() {
        return size == arr.length -1;
    }

    public boolean isEmpty() {
        return front == -1 && back == -1;
    }
}
