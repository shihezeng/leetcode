package easy;

public class Q234_palindrome_linked_list {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) return true;
		ListNode cur = head;
		ListNode curNext = head.next;
		ListNode reserve = new ListNode(head.val);
		while (cur != null && curNext != null) {
			reserve.next = new ListNode(curNext.val);
			
		}
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
		System.out.println("a" == new String("a"));
		// System.out.println(isPalindrome(a));
	}

}
