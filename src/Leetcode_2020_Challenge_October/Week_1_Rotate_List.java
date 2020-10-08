package Leetcode_2020_Challenge_October;

public class Week_1_Rotate_List {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int size = 1;
        ListNode node = head;
        ListNode newEnd, newHead, oldEnd;

        while (true) {
            node = node.next;
            ++size;
            if (node.next == null) {
                oldEnd = node;
                break;
            }
        }
        k = k % size;
        if (k == 0) return head;
        int x = size - k;
        node = head;
        if (x == 1) {
            newEnd = node;
            newHead = node.next;
        } else {
            while (true) {
                node = node.next;
                --x;
                if (x == 1) {
                    newEnd = node;
                    newHead = node.next;
                    break;
                }
            }
        }
        oldEnd.next = head;
        newEnd.next = null;
        return newHead;
    }
}


class ListNode {
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

