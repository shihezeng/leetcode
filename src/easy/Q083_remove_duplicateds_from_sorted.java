package easy;

public class Q083_remove_duplicateds_from_sorted {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
    
    public static void printListNode(ListNode n){
        while(n!=null){
            System.out.print(n.val+"->");
            n=n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        printListNode(deleteDuplicates(n1));
    }

}
