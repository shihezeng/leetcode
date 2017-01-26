package easy;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class Q111_minimum_depth_of_binary_tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            depth++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        return depth;
    }

    public static int minDepthR(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return minDepthR(root.right) + 1;
        if (root.right == null)
            return minDepthR(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.left)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(3);
        root.left = b;
        root.right = c;
        c.left = d;
        System.out.println(minDepth(root));
        System.out.println(minDepthR(root));
    }

}
