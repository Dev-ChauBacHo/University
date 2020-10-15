package Leetcode_2020_Challenge_October;

public class Week_2_House_Robber_II {
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 3};
        int result = rob(nums);
        System.out.println(result);
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length-1), rob(nums, 1, nums.length));
    }

    public static int rob(int[] nums, int start, int end) {
        int preMax = 0;
        int newMax = 0;
        int temp;
        for (int i = start; i < end; i++) {
            temp = newMax;
            if (nums[i] + preMax > newMax) {
                newMax = nums[i] + preMax;
            }
            preMax = temp;
        }
        return newMax;
    }
}
