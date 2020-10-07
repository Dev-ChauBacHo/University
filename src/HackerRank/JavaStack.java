package HackerRank;

import java.util.Scanner;
import java.util.Stack;

public class JavaStack {
    private static final Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        /*
        (: 1 --- [: 2 --- {: 3
         */
        String s = reader.nextLine();
        String result = "true";
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(1);
            }
            if (s.charAt(i) == '[') {
                stack.push(2);
            }
            if (s.charAt(i) == '{') {
                stack.push(3);
            }
            if (s.charAt(i) == ')') {
                if (stack.peek() != 1) {
                    result = "false";
                    break;
                } else {
                    stack.pop();
                }
            }
            if (s.charAt(i) == ']') {
                if (stack.peek() != 2) {
                    result = "false";
                    break;
                } else {
                    stack.pop();
                }
            }
            if (s.charAt(i) == '}') {
                if (stack.peek() != 3) {
                    result = "false";
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.size() != 1) result = "false";
        System.out.println(result);
    }
}
