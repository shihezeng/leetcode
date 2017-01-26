package easy;

//https://leetcode.com/problems/path-sum/
public class Q112_path_sum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.left==null && root.right==null) return root.val == sum;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(9);
        TreeNode left2 = new TreeNode(1);
        root.left = left;
        root.right = right;
        left.left = left2;
        System.out.println(hasPathSum(root, 5));
        System.out.println(hasPathSum(root, 6));
    }

}
