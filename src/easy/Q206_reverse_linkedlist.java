package easy;


//https://leetcode.com/problems/reverse-linked-list/
public class Q206_reverse_linkedlist {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode old = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = old;
            old = head;
            head = next;
        }
        return old;
    }
    
    public static ListNode reverseListR(ListNode head) {
        return reverseListR(head, null);
    }
    
    public static ListNode reverseListR(ListNode head, ListNode next) {
        if(head == null)
            return next;
        ListNode newHead = head.next;
        head.next = next;
        return reverseListR(newHead, head);
    }

    public static void printListNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "-->");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        printListNode(reverseListR(n1));
    }
}
