package Leetcode_2020_Challenge_November;

public class Week_2_Maximum_Difference_Between_Node_And_Ancestor {
    private static int result;
    public static void main(String[] args) {

    }

    public int maxAncestorDiff(TreeNode root) {
        result = -1;
        process(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return result;
    }

    private void process(TreeNode node, int max, int min) {
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        result = Math.max(result, (max - min));
        if (node.left != null) {
            process(node.left, max, min);
        }
        if (node.right != null) {
            process(node.right, max, min);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
