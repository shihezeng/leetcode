package easy;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/same-tree/
public class Q100_same_tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null)
			return p == q;
		return p.val == q.val && isSameTree(p.left, q.left)
				&& isSameTree(p.right, q.right);
	}

	public static boolean isSameTree2(TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			return p == q;
		}
		Queue<TreeNode> pQueue = new LinkedList<TreeNode>();
		Queue<TreeNode> qQueue = new LinkedList<TreeNode>();
		pQueue.offer(p);
		qQueue.offer(q);
		TreeNode pn;
		TreeNode qn;
		while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
			pn = pQueue.poll();
			qn = qQueue.poll();
			if (pn.val != qn.val)
				return false;
			if (pn.left != null)
				pQueue.add(pn.left);
			if (qn.left != null)
				qQueue.add(qn.left);
			if (pQueue.size() != qQueue.size())
				return false;
			if (pn.right != null)
				pQueue.add(pn.right);
			if (qn.right != null)
				qQueue.add(qn.right);
			if (pQueue.size() != qQueue.size())
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode p = new TreeNode(2);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		p.left = left;
		p.right = right;

		TreeNode q = new TreeNode(2);
		TreeNode left2 = new TreeNode(1);
		TreeNode right2 = new TreeNode(3);
		TreeNode right2_left = new TreeNode(4);
		q.left = left2;
		q.right = right2;
		right2.left = right2_left;

		System.out.println(isSameTree(p, q));
		System.out.println(isSameTree2(p, q));
	}
}
