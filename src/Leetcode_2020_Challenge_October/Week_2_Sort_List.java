package Leetcode_2020_Challenge_October;

public class Week_2_Sort_List {
    public static void main(String[] args) {

    }

    public static ListNode sortList(ListNode head) {
        ListNode x = head;
        while (x != null) {
            ListNode y = x.next;
            while (y != null) {
                if (y.val < x.val) {
                    int temp = x.val;
                    x.val = y.val;
                    y.val = temp;
                }
                y = y.next;
            }
            x = x.next;
        }
        return  head;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
