package linkedlist;

import kotlin.Pair;

import java.util.NoSuchElementException;
import java.util.Stack;

public class SLL {

    public static void main(String[] args) {
        SLL sll = new SLL();
        sll.pushFront(6);
        sll.pushFront(4);
        sll.pushFront(3);
        sll.pushFront(1);

        SLL sll2 = new SLL();
        sll2.pushFront(9);
        sll2.pushFront(7);
        sll2.pushFront(5);
        sll2.pushFront(1);
        sll.print();
        Node marge = sll.marge(sll.head, sll2.head);
        System.out.println(marge);
        sll.print();
    }

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

    Node getMiddleNode(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            size++;
        }
        return fast != null ? slow.next : slow;
    }

    Node reverse() {
        Node prev = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        return prev;
    }

    Pair<Node, Node> divide() {
        Node middleNode = getMiddleNode(this.head);
        Node node2;
        node2 = middleNode.next;
        middleNode.next = null;
        return new Pair<>(head, node2);
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

    Node insertionSortList() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Node sortList(Node head) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    Node marge(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node result = dummy;
        while (head1 != null || head2 != null) {
            if (head1 == null) {
                dummy.next = head2;
                break;
            }

            if (head2 == null) {
                dummy.next = head1;
                break;
            }

            if (head1.value <= head2.value) {
                dummy.next = head1;
                head1 = head1.next;
            } else {
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
        }
        return result.next;
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

    public boolean isPalindrome(Node head) {
        Stack<Integer> integers = new Stack<>();
        Node cur = head;
        while (cur != null) {
            integers.push(cur.value);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            if (integers.pop() != cur.value) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    public void deleteGivenNode(Node node) {
        node.value = node.next.value;
        node.next = node.next.next;
    }

    private static class Node {
        private int value;
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
