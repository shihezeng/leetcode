package easy;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/symmetric-tree/
public class Q101_symmetric_tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null || root.right == null) {
            return root.left == root.right;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root.left);
        queue.offer(root.right);
        TreeNode left = null;
        TreeNode right = null;
        while (!queue.isEmpty() && !queue.isEmpty()) {
            left = queue.poll();
            right = queue.poll();
            if (left.val != right.val) {
                return false;
            }
            if (left.left == null || right.right == null) {
                if (left.left != right.right)
                    return false;
            }
            if (left.right == null || right.left == null) {
                if (left.right != right.left)
                    return false;
            }
            if (left.left != null) {
                queue.add(left.left);
                queue.add(right.right);
            }
            if (left.right != null) {
                queue.add(left.right);
                queue.add(right.left);
            }
        }
        return true;
    }

    public static boolean isSymmetricR(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetricR(root.left, root.right);
    }

    public static boolean isSymmetricR(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        } else if (left.val != right.val) {
            return false;
        } else {
            return isSymmetricR(left.left, right.right)
                    && isSymmetricR(left.right, right.left);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        TreeNode ll = new TreeNode(4);
        TreeNode rr = new TreeNode(4);
        root.left = left;
        root.right = right;
        left.left = ll;
        right.right = rr;
        System.out.println(isSymmetric(root));
    }
}
