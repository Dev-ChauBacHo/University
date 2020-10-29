package Leetcode_2020_Challenge_October;

import java.util.Stack;

public class Week_3_Linked_List_Cycle_II {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
