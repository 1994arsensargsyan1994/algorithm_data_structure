package stack;

public class Stack {
    private final int[] storage;
    private int top;
    private final int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        top = -1;
        storage = new int[capacity];
    }

    public void push(int elm) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        storage[++top] = elm;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return storage[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return storage[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}