package L210_Leetcode_Weekly_Contest;

public class L5535_Maximum_Nesting_Depth_Of_The_Parentheses {

    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }

    public static int maxDepth(String s) {
        int count = 0;
        int result = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++count;
            }
            if (c == ')') {
                result = Math.max(count, result);
                --count;
            }
        }
        return result;
    }
}
