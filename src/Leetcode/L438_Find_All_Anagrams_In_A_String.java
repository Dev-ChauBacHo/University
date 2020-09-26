package Leetcode;

import java.util.*;

public class L438_Find_All_Anagrams_In_A_String {
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        String s = reader.nextLine();
        String p = reader.nextLine();
        System.out.println(findAnagrams(s, p).toString());

    }

    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        int numOfLettersInP;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        numOfLettersInP = map.size();
        while (end < s.length()) {
            char c = s.charAt(end);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) --numOfLettersInP;
            }
            ++end;

            while (numOfLettersInP == 0) {
                char c1 = s.charAt(start);

                if (map.containsKey(c1)) {
                    map.put(c1, map.get(c1) + 1);
                    if (map.get(c1) > 0) {
                        ++numOfLettersInP;
                    }
                }
                if (end - start == p.length()) {
                    result.add(start);
                }
                ++start;
            }

        }

        return result;
    }
}
