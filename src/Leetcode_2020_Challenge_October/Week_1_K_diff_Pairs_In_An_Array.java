package Leetcode_2020_Challenge_October;

import java.util.HashMap;
import java.util.Map;

public class Week_1_K_diff_Pairs_In_An_Array {
    public static void main(String[] args) {
        int[] nums = {1,3,1,5,4};
        int k = 0;
        System.out.println(findPairs(nums, k));
    }

    public static int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int result = 0;
        for (int i : nums) {
            int count = hashMap.getOrDefault(i, 0);
            hashMap.put(i, count + 1);
        }

        for (Map.Entry<Integer, Integer> i : hashMap.entrySet()) {
            if (k == 0) {
                if (i.getValue() > 1)
                    ++result;
            } else {
                int a = i.getKey();
                if (hashMap.containsKey(a + k)) {
                    ++result;
                }
            }
        }

        return result;
    }
}
