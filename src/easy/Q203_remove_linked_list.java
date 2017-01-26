package easy;

//https://leetcode.com/problems/remove-linked-list-elements/
public class Q203_remove_linked_list {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode removeElements(ListNode head, int val) {
		ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next =  cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return dummyHead.next;
	}
	
	public static void printListNode(ListNode n){
		System.out.print("[");
		while(n!=null){
			System.out.print(n.val+",");
			n=n.next;
		}
		System.out.println("]");
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode(2);
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(1);
		ListNode d = new ListNode(2);
		head.next =a;
		a.next=b;
		b.next= c;
		c.next=d;
		printListNode(head);
		ListNode result = removeElements(head, 2);
		printListNode(result);
	}
}
