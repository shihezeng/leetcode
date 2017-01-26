package easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import util.BTreePrinter;
import util.Node;

//https://leetcode.com/problems/invert-binary-tree/
//solution: https://discuss.leetcode.com/topic/16039/straightforward-dfs-recursive-iterative-bfs-solutions
public class Q226_invert_binary_tree<T> {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.left = right;
		root.right = left;
		return root;
	}

	public static <T extends Comparable<?>> Node<T> invertTree(Node<T> root) {
		if (root != null) {
			Node<T> left = root.left;
			root.left = invertTree(root.right);
			root.right = invertTree(left);
		}
		return root;
	}

	public static <T extends Comparable<?>> Node<T> invertTreeBFS(Node<T> root) {
		if (root == null)
			return root;
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node<T> node = queue.poll();
			Node<T> tmp = node.left;
            node.left = node.right;
            node.right = tmp;
			if (node.right != null) {
				queue.offer(node.right);
			}
			if (node.left != null) {
				queue.offer(node.left);
			}
		}
		return root;
	}
	
	public static <T extends Comparable<?>> Node<T> invertTreeDFS(Node<T> root) {
		if (root == null)
			return root;
		Deque<Node<T>> queue = new LinkedList<Node<T>>();
		queue.push(root);
		while (!queue.isEmpty()) {
			Node<T> node = queue.pop();
			Node<T> tmp = node.left;
            node.left = node.right;
            node.right = tmp;
			if (node.right != null) {
				queue.push(node.right);
			}
			if (node.left != null) {
				queue.push(node.left);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(1);
		Node<Integer> n1 = new Node<Integer>(4);
		Node<Integer> n2 = new Node<Integer>(2);
		Node<Integer> n3 = new Node<Integer>(6);
		Node<Integer> n4 = new Node<Integer>(7);
		Node<Integer> n5 = new Node<Integer>(2);
		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n2.left = n4;
		n2.right = n5;
		BTreePrinter.printNode(root);
//		BTreePrinter.printNode(invertTreeBFS(root));
		BTreePrinter.printNode(invertTreeDFS(root));
	}
}
