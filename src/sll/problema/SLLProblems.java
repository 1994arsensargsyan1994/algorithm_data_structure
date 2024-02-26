package sll.problema;

public class SLLProblems {

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        ListNode node5 = new ListNode();
        node1.val = 1;
        node2.val = 2;
        node3.val = 3;
        node4.val = 4;
        node5.val = 5;

        node1.next = node2;
        node2.next = node3;
        node3.next  = node4;
        node4.next  = node5;


        ListNode node = swapNodes(node1, 5);
        System.out.println(node);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;
        ListNode cur = head;
        int size = 1;
        while (cur.next != null) {
            cur = cur.next;
            ++size;
        }
        cur.next = head;

        int i = size - k % size;

        for (int j = 0; j < i; ++j)
            cur = cur.next;

        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;
    }

    public static ListNode swapNodes(ListNode head, int k) {
        if(k ==0) return head;
        if(head.next == null) return head;
        ListNode prev = head;
        ListNode cur = head;
        ListNode tmp = null;
        int size = 0;
        int  i = k;
        while (cur != null){
            if (k > 0){
                tmp = cur;
            }
            if (k >= 0){
                prev = head;
            }
            prev = prev.next;
            cur = cur.next;
            --k;
            size++;
        }
        if (size == i){
            int val = head.val;
            head.val = tmp.val;;
            tmp.val = val;
           return head;
        }else {
            int val = tmp.val;
            tmp.val = prev.val;
            prev.val = val;
        }



        return head;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}