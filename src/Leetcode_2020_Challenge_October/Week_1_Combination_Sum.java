package Leetcode_2020_Challenge_October;

import java.util.*;

public class Week_1_Combination_Sum {
    private static List<List<Integer>> result = new ArrayList<>();
    private static Stack<Integer> combination = new Stack<>();
    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        System.out.println(combinationSum(candidates, target).toString());
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(0, candidates, target);
        return result;
    }

    private static void backTrack(int start, int[] arr, int remain) {
        if (remain < 0) return;
        if (remain == 0) {
            result.add(new ArrayList<>(combination));
//            System.out.println(combination.toString());
        }
        for (int i = start; i < arr.length; i++) {
            int temp = arr[i];
            remain -= temp;
            combination.push(temp);
            backTrack(i, arr, remain);
            remain += temp;
            combination.pop();
        }
    }
}
