package linkedlist;

import kotlin.Pair;

import java.util.NoSuchElementException;
import java.util.Objects;

public class DLL {

    public static void main(String[] args) {
        DLL DLL = new DLL();
        DLL.pushFront(4);
        DLL.pushFront(8);
        DLL.pushBack(96);
        DLL.pushFront(10);
        DLL.pushFront(11);
        DLL.pushFront(12);
        DLL.print();
        System.out.println();
        Node middleNode = DLL.getMiddleNode();
        System.out.println(middleNode);
        Pair<Node, Node> divide = DLL.divide();
        System.out.println(divide);

//        DLL.head.next.next = DLL.head;
//        System.out.println(DLL.hasCycle());
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

    Node getMiddleNode() {
        Node slow = head;
        Node fast = head.next;
        int count = 0;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }
        return slow;
    }

    Pair<Node, Node> divide() {
        Node middleNode = getMiddleNode();
        Node node2;
        node2 = middleNode.next;
        middleNode.next = null;
        return new Pair<>(head, node2);
    }

    boolean hasCycle() {
        Node slow = head;
        Node fast = head;

        while (slow.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                return true;
            }
        }
        return false;
    }

    static class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value && Objects.equals(next, node.next) && Objects.equals(prev, node.prev);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next, prev);
        }

        @Override
        public String toString() {
            return String.format("%s ,", value);
        }
    }
}
