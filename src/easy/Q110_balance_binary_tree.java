package easy;

//https://leetcode.com/problems/balanced-binary-tree/
public class Q110_balance_binary_tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int leftHeight = depth(root.left);
        int rightHeight = depth(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public static int depth(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

    public static boolean isBalanced2(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    public static int dfsHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1)
            return -1;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(30);
        TreeNode n5 = new TreeNode(60);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n4.left = n5;
        System.out.println(isBalanced2(n1));
    }
}
