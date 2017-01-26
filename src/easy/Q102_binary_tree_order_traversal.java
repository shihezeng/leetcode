package easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal/
public class Q102_binary_tree_order_traversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arrays = new LinkedList<List<Integer>>();
        if (root == null)
            return arrays;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int nodeCount = queue.size();
            List<Integer> array = new LinkedList<Integer>();
            for (int i = 0; i < nodeCount; i++) {
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                array.add(queue.poll().val);
            }
            arrays.add(array);
        }
        return arrays;
    }

    public static List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> arrays = new LinkedList<List<Integer>>();
        levelOrderDFS(root, 0, arrays);
        return arrays;
    }

    public static void levelOrderDFS(TreeNode root, int level,
            List<List<Integer>> arrays) {
        if (root == null)
            return;
        if (level >= arrays.size()) {
            arrays.add(new LinkedList<Integer>());
        }
        levelOrderDFS(root.left, level + 1, arrays);
        levelOrderDFS(root.right, level + 1, arrays);
        arrays.get(level).add(root.val);
    }

    public static void main(String[] args) {
        TreeNode center = new TreeNode(10);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(20);
        center.left = left;
        center.right = right;
        System.out.println(levelOrderDFS(center));
    }
}
