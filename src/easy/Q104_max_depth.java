package easy;


//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class Q104_max_depth {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
	}
	public static void main(String[] args) {
	}

}
