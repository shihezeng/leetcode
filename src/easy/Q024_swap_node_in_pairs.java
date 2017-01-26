package easy;

//https://leetcode.com/problems/swap-nodes-in-pairs/
public class Q024_swap_node_in_pairs {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public String toString() {
            String result = "[" + val + "]";
            while (next != null) {
                return result += "->" + next.toString();
            }
            return result;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode curNext = cur.next;
            cur.next = curNext.next;
            curNext.next = cur.next.next;
            cur.next.next = curNext;
            cur = curNext;
        }
        return dummyHead.next;
    }
    
    public static ListNode swapPairsR(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(head.next.next);
        newHead.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        System.out.println(swapPairsR(n1));
    }
}
