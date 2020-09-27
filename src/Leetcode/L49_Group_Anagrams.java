package Leetcode;

import java.util.*;

public class L49_Group_Anagrams {
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        String input = reader.nextLine();
        String[] s = input.split("\",\"");
        System.out.println(groupAnagrams(s).toString());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s: strs) {
            // make key
            String key = encode(s);
            // Create a new List (for storing group of strings)
            // or get the existing List
            List<String> group = map.getOrDefault(key, new ArrayList<>());
            // add the new anagram string to the List
            group.add(s);
            // Modify the HashMap
            map.put(key, group);
        }
        System.out.println(map.toString());
        return new ArrayList<>(map.values());
    }

    /*
        This is the unique key for the HashMap.
        Simply count each letters in the string s into an array
    */
    private static String encode(String s) {
        int[] key = new int[26];
        for (char c: s.toCharArray()) {
            int index = c - 'a';
            ++key[index];
        }
        return Arrays.toString(key);
    }
}
