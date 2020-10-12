package Leetcode_2020_Challenge_October;

public class Week_2_Buddy_Strings {
    public static void main(String[] args) {
        System.out.println(buddyStrings("abac", "abad"));
    }

    public static boolean buddyStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        int c1 = -1, c2 = -1;
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (count == 0) c1 = i;
                if (count == 1) c2 = i;
                ++count;
                if (count > 2) return false;
            }
        }
        if (count == 1 ) return false;
        if (c1 == c2 && c1 == -1) return checkIfEqual(a);
        if (a.charAt(c1) == b.charAt(c2) && a.charAt(c2) == b.charAt(c1)) {
            return true;
        }
        return  false;
    }

    private static boolean checkIfEqual(String a) {
        int[] letters = new int[26];
        for (char c : a.toCharArray()) {
            int temp = (int) c - 97;
            ++letters[temp];
            if (letters[temp] > 1) return true;
        }
        return false;
    }
}
