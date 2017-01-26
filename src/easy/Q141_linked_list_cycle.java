package easy;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/submissions/detail/73953118/
//https://discuss.leetcode.com/topic/12516/o-1-space-solution
public class Q141_linked_list_cycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycleS(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<ListNode>();
        while (head.next != null) {
            if (!set.add(head.next)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        node2.next = node1;
        System.out.println(hasCycle(node1));
        // System.out.println(node1 == node2);
    }
}
