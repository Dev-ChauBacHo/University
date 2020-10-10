package Leetcode_2020_Challenge_October;

public class Week_2_Serialize_And_Deserialize_BST {
    // Using StringBuilder helps reducing Runtime from 23ms to 3ms
    private static StringBuilder s;
    public static void main(String[] args) {
//        String data = "95 91 97 100 27 14 79 7 57 90";
        String data = "95 91 27 14 7 79 57 90 97 100";
        TreeNode root = deserialize(data);
        printTreeNode(root);
        System.out.println("here" + serialize(root));
    }

    public static String serialize(TreeNode root) {
        s = new StringBuilder();
        createBSTString(root);
        return s.toString();
    }

    public static TreeNode deserialize(String data) {
        if (data == null || data.equalsIgnoreCase(""))
            return null;
        String[] nums = data.split(" ");
        TreeNode root = null;
        TreeNode node;
        for (String s : nums) {
            int num = Integer.parseInt(s); //Should use try catch
            if (root == null) {
                root = new TreeNode(num);
            } else {
                node = root;
                insertIntoBST(node, num);
            }
        }
        return root;
    }

    private static void insertIntoBST(TreeNode node, int val) {
        if (val <= node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else
                insertIntoBST(node.left, val);
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else
                insertIntoBST(node.right, val);
        }
    }

    private static void printTreeNode(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTreeNode(root.left);
        printTreeNode(root.right);
    }

    private static void createBSTString(TreeNode root) {
        if (root == null) return;
        s.append(root.val).append(" ");
        createBSTString(root.left);
        createBSTString(root.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

