package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class L242_Valid_Anagram {
    private static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        String s = reader.nextLine();
        String p = reader.nextLine();
        System.out.println(isAnagram(s, p));
    }

    private static boolean isAnagram(String s, String p) {
        Map<Character, Integer> hashTblOfS = new HashMap<>();
        for (char c: s.toCharArray()) {
            hashTblOfS.put(c, hashTblOfS.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> hashTblOfP = new HashMap<>();
        for (char c: p.toCharArray()) {
            hashTblOfP.put(c, hashTblOfP.getOrDefault(c, 0) + 1);
        }

//        System.out.println(hashTblOfS);
//        System.out.println(hashTblOfP);

        return hashTblOfS.equals(hashTblOfP);
    }
}
