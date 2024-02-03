package linkedlist;

import java.util.NoSuchElementException;

public class SLL {

    private int size;
    private Node head = null;

    public void pushFront(int value) {
        Node newNode = new Node(value);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    public void pushBack(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            pushFront(value);
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    public int popFront() {
        if (head == null) {
            throw new NoSuchElementException("SLL is empty");
        }
        int value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public int popBack() {
        if (head == null) {
            throw new NoSuchElementException("SLL is empty");
        } else if (size == 1) {
            popFront();
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        int value = current.next.value;
        current.next = null;
        size--;
        return value;
    }

    void print() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur);
            cur = cur.next;
        }
    }

    public void add(int value, int index) {
        if (size < index) {
            throw new IllegalArgumentException("No such index");
        }
        if (index == 0) {
            pushFront(value);
        } else if (index == size - 1) {
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

    public void addAll(int index, SLL sll) {
        if (size < index) {
            throw new IllegalArgumentException("No such index");
        } else if (isEmpty() && index == 0) {
            head = sll.head;
        } else if (index == 0) {
            Node last = getLast(sll);
            last.next = head;
            head = sll.head;
        } else {
            Node cur = head;
            while (--index > 0) {
                cur = cur.next;
            }
            Node last = getLast(sll);
            last.next = cur.next;
            cur.next = sll.head;
        }
        size += sll.size;
    }

    public void remove(int index) {
        if (size < index) {
            throw new IllegalArgumentException("No such index");
        }
        if (index == 0) {
            popFront();
        } else if (index == size - 1) {
            popBack();
        } else {
            Node cur = head;
            while (--index > 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            size--;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node getLast(SLL sll) {
        if (sll.head == null) {
            throw new NoSuchElementException("SLL is empty");
        }
        Node current = sll.head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    private static class Node {
        private final int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("%s ,", value);
        }
    }
}
