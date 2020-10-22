package Leetcode_2020_Challenge_October;

import java.util.LinkedList;
import java.util.Queue;

public class Week_3_Minimum_Depth_Of_Binary_Tree {
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode node) {
        if (node == null) return 0;
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            // number of Node in the same height
            int numOfNodes = queue.size();
            while (numOfNodes > 0) {
                node = queue.poll();
                if (node.left == null && node.right == null) {
                    return count;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
                --numOfNodes;
            }
            ++count;
        }
        return 0;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
