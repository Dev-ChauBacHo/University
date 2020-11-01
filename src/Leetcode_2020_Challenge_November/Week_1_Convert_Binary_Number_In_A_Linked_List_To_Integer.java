package Leetcode_2020_Challenge_November;

public class Week_1_Convert_Binary_Number_In_A_Linked_List_To_Integer {

    public static void main(String[] args) {

    }

    public static int getDecimalValue(ListNode head) {
        ListNode node = head;
        StringBuilder sb = new StringBuilder();
        int result = 0;
        int binary = 1;
        while (node != null) {
            sb.append(node.val);
            node = node.next;
        }
        for (int i = sb.length() - 1; i >= 0; i--) {
            result += binary * (Integer.parseInt(String.valueOf(sb.charAt(i))));
            binary *= 2;
        }
        return result;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
