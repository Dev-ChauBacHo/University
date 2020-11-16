package Leetcode_2020_Challenge_November;

public class Week_3_Longest_Mountain_In_Array {

    public static void main(String[] args) {
        int[] A = {0,0,1,0,0,1,1,1,1,1};
        System.out.println(longestMountain(A));
    }

    public static int longestMountain(int[] A) {
        int max = 0;
        int count = 1;
        boolean hasTop = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                if (hasTop) max = Math.max(max, count);
                hasTop = false;
                count = 1;
            }
            if (A[i] > A[i - 1]) {
                if (hasTop) {
                    max = Math.max(max, count);
                    count = 2;
                    hasTop = false;
                } else {
                    ++count;
//                    System.out.println(count);
                }
            }
            if (A[i] < A[i - 1] & count > 1) {
                ++count;
                hasTop = true;
//                System.out.println(count);
            }
        }
        if (hasTop) max = Math.max(max, count);
        if (max == 1) return 0;
        return max;
    }
}
