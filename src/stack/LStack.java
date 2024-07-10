package stack;

public class LStack {

    Node first;

    public LStack() {
        this.first = null;
    }

    public void push(int val){
        Node old = first;
        first = new Node(val);
        first.next = old;
    }

    public int pop(){
        int val = first.val;
        first = first.next;
        return val;
    }

    static class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }
}
