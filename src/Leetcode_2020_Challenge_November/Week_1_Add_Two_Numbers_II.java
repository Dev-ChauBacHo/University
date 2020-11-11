package Leetcode_2020_Challenge_November;

public class Week_1_Add_Two_Numbers_II {
    public static void main(String[] args) {
        StringBuilder num2 = new StringBuilder("1");
        StringBuilder num1 = new StringBuilder("23132132");
        System.out.println(addBigNumbers(num1, num2));
        System.out.println(num1);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        while (l1 != null) {
            num1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            num2.append(l2.val);
            l2 = l2.next;
        }
        ListNode result = new ListNode();
        ListNode node = result;
        String sb = addBigNumbers(num1, num2);
        for (int i = 0; i < sb.length(); i++) {
            node.val = sb.charAt(i) - '0';
            if (i == sb.length() - 1) {
                node.next = null;
                break;
            }
            node.next = new ListNode();
            node = node.next;
        }
        return result;
    }
    private static String addBigNumbers(StringBuilder num1, StringBuilder num2) {
        num1.reverse();
        num2.reverse();
        StringBuilder result = new StringBuilder();
        int length1;
        int length2;
        if (num1.length() > num2.length()) {
            StringBuilder s = num1;
            num1 = num2;
            num2 = s;
        }
        length1 = num1.length();
        length2 = num2.length();
        int flag = 0;
        int x, y, z;
        for (int i = 0; i < length1; i++) {
            x = num1.charAt(i) - '0';
            y = num2.charAt(i) - '0';
            z = x + y + flag;
            result.append(z % 10);
            flag = (z > 9) ? 1 : 0;
        }
        for (int i = length1; i < length2; i++) {
            x = 0;
            y = num2.charAt(i) - '0';
            z = x + y + flag;
            result.append(z % 10);
            flag = (z > 9) ? 1 : 0;
        }
        if (flag == 1) result.append(1);
        return result.reverse().toString();
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
