package Leetcode_2020_Challenge_November;

public class Week_2_Consecutive_Characters {
    public static void main(String[] args) {
        String s = "cc";
        System.out.println(maxPower(s));
    }

    public static int maxPower(String s) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;
        int count = 1;
        int result = -1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                ++count;
            } else {
                result = Math.max(result, count);
                count = 1;
            }
        }
        result = Math.max(result, count);
        return result;
    }
}
