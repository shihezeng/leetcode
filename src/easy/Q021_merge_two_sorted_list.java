package easy;

//https://leetcode.com/problems/merge-two-sorted-lists/
//https://discuss.leetcode.com/topic/2513/a-recursive-solution/7
public class Q021_merge_two_sorted_list {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public String toString() {
            String result = "[" + val + "]";
            while (this.next != null) {
                return result += "->" + this.next.toString();
            }
            return result;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                current = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                current = l2;
                l2 = l2.next;
            }
        }
        current.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }
    
    public static ListNode mergeTwoListsR(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val<l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n3;
        n2.next = n4;

//        System.out.println(mergeTwoListsR(n1, n2));
        System.out.println(mergeTwoLists(null, null));
    }
}
