package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
//https://discuss.leetcode.com/topic/7651/my-dfs-and-bfs-java-solution
public class Q107_binary_tree_level_oder_ii {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // BFS
    public static List<List<Integer>> levelOrderBottomBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            int nodeCount = queue.size();
            for (int i = 0; i < nodeCount; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                list.add(queue.poll().val);
            }
            result.add(0, list);
        }
        return result;
    }

    // DFS
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        levelOrderBottom(root, result, 0);
        return result;
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root,
            List<List<Integer>> result, int level) {
        if (root == null)
            return result;
        if (level >= result.size()) {
            result.add(0, new ArrayList<Integer>());
        }
        levelOrderBottom(root.left, result, level + 1);
        levelOrderBottom(root.right, result, level + 1);
        result.get(result.size() - level - 1).add(root.val);
        return result;
    }

    public static void main(String[] args) {
        TreeNode center = new TreeNode(10);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(20);
        center.left = left;
        center.right = right;
        System.out.println(levelOrderBottom(center));
    }

}
