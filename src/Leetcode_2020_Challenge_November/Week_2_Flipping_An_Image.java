package Leetcode_2020_Challenge_November;

import java.util.Arrays;

public class Week_2_Flipping_An_Image {
    public static void main(String[] args) {
        int[][] A = {
                {1, 1, 0}, {1, 0, 1}, {0, 0, 0}
        };
        System.out.println(Arrays.deepToString(flipAndInvertImage(A)));
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int mid = n / 2;
        if (n % 2 == 1) ++mid;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < mid; j++) {
                int temp = A[i][j];
                A[i][j] = invert(A[i][n - j - 1]);
                A[i][n - j - 1] = invert(temp);
            }
        }
        return A;
    }

    private static int invert(int a) {
        if (a == 0) return 1;
        return 0;
    }
}
