package easy;

import java.util.ArrayList;
import java.util.List;

public class Q019_remove_nth_node_from_end {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> result = new ArrayList<ListNode>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        result.add(dummy);
        while (head != null) {
            result.add(head);
            head = head.next;
        }
        if (result.size() > n) {
            result.get(result.size() - n - 1).next = result
                    .get(result.size() - n).next;
            result.get(result.size() - n).next = null;
        } else {
            dummy.next = dummy.next.next;
            result.get(1).next = null;
        }
        return dummy.next;
    }

    public static void printListNode(ListNode n) {
        while (n != null) {
            System.out.print(n.val + "->");
            n = n.next;
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
        printListNode(removeNthFromEnd(n1, 2));
    }

}
