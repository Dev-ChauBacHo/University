package Leetcode_2020_Challenge_November;

public class Week_2_Binary_Tree_Tilt {
    private int result;

    public int findTilt(TreeNode root) {
        result = 0;
        process(root, 0, 0);
        return result;
    }

    private void process(TreeNode node, int left, int right) {
        int temp;
        if (node.left != null) {
            temp = node.left.val;
            process(node.left, left, right);
            left += temp;
        } else {
            left = 0;
        }
        if (node.right != null) {
            temp = node.right.val;
            process(node.right, left, right);
            right += temp;
        } else {
            right = 0;
        }

        node.val = left - right;
        if (node.val < 0) node.val *= -1;
        result += node.val;
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
