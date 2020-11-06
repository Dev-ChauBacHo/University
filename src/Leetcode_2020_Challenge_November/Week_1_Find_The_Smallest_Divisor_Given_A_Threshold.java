package Leetcode_2020_Challenge_November;

public class Week_1_Find_The_Smallest_Divisor_Given_A_Threshold {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2};
        int n = 4;
        System.out.println(smallestDivisor(nums, n));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int maxNums = -1;
        for (int i: nums) {
            maxNums = Math.max(maxNums, i);
        }
        int start = 1;
        int end = maxNums;
        int pivot;
        int sum;
        while (start != end) {
            pivot = start + (end - start) / 2;
            sum = calSum(nums, pivot);
            System.out.println(pivot + ": " + sum);
            if (sum <= threshold) {
                end = pivot;
            } else {
                start = pivot + 1;
            }
        }

        return end;
    }

    private static int calSum(int[] nums, int divisor) {
        int sum = 0;
        for (int i: nums) {
//            sum += Math.ceil(i / (double)divisor);
            sum += (i + divisor - 1) / divisor;
        }
        return sum;
    }
}
