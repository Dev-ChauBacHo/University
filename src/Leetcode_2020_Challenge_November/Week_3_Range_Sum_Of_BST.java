package Leetcode_2020_Challenge_November;

import java.util.Stack;

public class Week_3_Range_Sum_Of_BST {
    public static void main(String[] args) {

    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        int val;
        TreeNode node;
        sum += low + high;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            node = stack.peek();
            stack.pop();
            val = node.val;
            if (val > low && val < high) {
                sum += val;
            }
            if (node.left != null & val > low) stack.push(node.left);
            if (node.right != null & val < high) stack.push(node.right);
        }
        return sum;
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
