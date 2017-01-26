package easy;

//https://leetcode.com/problems/delete-node-in-a-linked-list/
public class Q237_delete_linkedlist {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	public static void deleteNode(ListNode node){
		node.val = node.next.val;
		node.next = node.next.next;
	}
	
	public static void printListNode(ListNode node){
		while(node!=null){
			System.out.print(node.val+"->");
			node = node.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		printListNode(node1);
		deleteNode(node3);
		printListNode(node1);
	}
}
