package linkedlist;

import java.util.NoSuchElementException;

public class DLL {

    public static void main(String[] args) {
        DLL DLL = new DLL();
        DLL.pushFront(4);
        DLL.pushFront(8);
        DLL.pushBack(96);
        DLL.pushFront(10);
        DLL.print();
        System.out.println();
        System.out.println(DLL.popFront());
        DLL.print();
        System.out.println();
        System.out.println(DLL.popBack());
        DLL.print();
        System.out.println();
        DLL.add(10, 1);
        DLL.print();
        System.out.println();
        DLL.remove(1);
        DLL.print();
    }

    private int size = 0;
    private Node head = null;
    private Node tail = null;

    public void pushFront(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        head.prev = newNode;
        newNode.next = head;
        head = newNode;
        size++;

    }

    public void pushBack(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            pushFront(value);
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public int popFront() {
        if (head == null) {
            throw new NoSuchElementException("SLL is empty");
        }
        int val = head.value;
        head = head.next;
        size--;
        return val;
    }

    public int popBack() {
        if (head == null) {
            throw new NoSuchElementException("SLL is empty");
        } else if (size == 1) {
            popFront();
        }
        int val = tail.value;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    public void add(int value, int index) {
        if (size < index) {
            throw new IllegalArgumentException("No such index");
        }
        if (index == 0) {
            pushFront(value);
        } else if (index == size) {
            pushBack(value);
        } else {
            Node node = new Node(value);
            Node cur = head;
            while (--index > 0) {
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
            size++;
        }
    }

    public void remove(int index) {
        if (size < index) {
            throw new IllegalArgumentException("No such index");
        }
        if (index == 0) {
            popFront();
        } else if (index == size) {
            popBack();
        } else {
            Node cur = head;
            while (--index > 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            cur.next.prev = cur;
            size--;
        }
    }

    void print() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur);
            cur = cur.next;
        }
    }

    static class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("%s ,", value);
        }
    }
}
