package Leetcode_2020_Challenge_October;

public class Week_1_Insert_Into_A_Binary_Search_Tree {
    public static void main(String[] args) {

    }

    public static TreeNode insertIntoBST(TreeNode root, int newVal) {
        if (root == null) {
            return new TreeNode(newVal, null, null);
        }
        TreeNode node = root;
        while (node != null) {
            if (newVal < node.val) {
                if (node.left == null) {
                    node.left = new TreeNode(newVal, null, null);
                    break;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(newVal, null, null);
                    break;
                }
                node = node.right;
            }
        }

        return root;
    }

}
class TreeNode {
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
