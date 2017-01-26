package easy;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class Q235_lowest_common_ancestor {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "Node:[" + val + "]";
        }
    }

    public static TreeNode lowestCommonAncestorR(TreeNode root, TreeNode p,
            TreeNode q) {
        if (p == null || q == null || root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
            TreeNode q) {
        if (p == null || q == null || root == null) {
            return null;
        }
        while ((root.val - (long) p.val) * (root.val - (long) q.val) > 0) {
            root = (root.val - p.val) > 0 ? root.left : root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node6.left = node2;
        node6.right = node8;
        node2.left = node0;
        node2.right = node4;
        node3.left = node3;
        node4.right = node5;
        node8.left = node8;
        node8.right = node9;

        System.out.println(lowestCommonAncestor(node6, node0, node4));
    }

}
