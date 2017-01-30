package easy;

public class Q234_palindrome_linked_list {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public String toString() {
            String result = val + "";
            if (next != null) {
                result += "->" + next;
            }
            return result;
        }
    }

    public static ListNode clone(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (head != null) {
            ListNode node = new ListNode(head.val);
            tail.next = node;
            tail = tail.next;
            head = head.next;
        }
        return dummy.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode clone = clone(head);
        ListNode rev = reverse(clone);
        while (head != null) {
            if (head.val != rev.val) return false;
            head = head.next;
            rev = rev.next;
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) slow = slow.next;
        fast = head;
        slow = reverse(slow);
        ListNode tmp = slow;
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        reverse(tmp);
        return true;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(2);
        ListNode g = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
//        System.out.println(isPalindrome(a));
//        System.out.println(a);
        System.out.println(isPalindrome2(a));
        System.out.println(a);
    }

}
