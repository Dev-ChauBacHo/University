package Leetcode_2020_Challenge_October;

import java.util.Arrays;
import java.util.Stack;

public class Week_3_132_Pattern {
    public static void main(String[] args) {
        int[] nums = {3,1,4,2};
        System.out.println(find132pattern(nums));
    }

    private static boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        // minVal[i] stores the min value from nums[0] to nums[i]
        int[] minVal = new int[nums.length];
        // stack saves potential numbers
        Stack<Integer> stack = new Stack<>();
        minVal[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            minVal[i] =  Math.min(minVal[i-1], nums[i]);
        }
        System.out.println(Arrays.toString(minVal));

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > minVal[i]) { // before nums[i] has a smaller number
                // so push nums[i] to stack
                // but before that we check if stack.peek() < minVal[i]
                // because stack only save potential number at nums[i], which means all values in stack must > minVal[i]
                // If stack.peek() < minVal[i] we need to pop it
                // If stack.peek() > minVal[i] and stack.peek() < nums[i] then return true, because
                // num[i] has smaller number before it and stack() has number > that smaller number and < num[i]
                // Note that since we store the min value at minVal[i] from nums[0] to nums[i] --> minVal[i] only can decrease
                // And we see nums from the last index, when pop the head element stack, there are no way there are
                // smaller number (< minVal[i]) exists in stack
                System.out.println(nums[i]);
                while (!stack.isEmpty() && stack.peek() <= minVal[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[i]) {
                    return true;
                }
                stack.push(nums[i]);
            }
        }

        return false;
    }

}

/*
     - At nums[i], we only care if there is a smaller nums before nums[i]
     so we find the min value from nums[0] to nums[i]
 */
