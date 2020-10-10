package Leetcode_2020_Challenge_October;

import java.util.Arrays;
import java.util.Comparator;

public class Week_2_Minimum_Number_Of_Arrows_To_Burst_Balloons {
    public static void main(String[] args) {
//        int[][] arr = {
//                {10, 16}, {2, 8}, {2, 3}, {1,6}, {7, 12}
//        };

//        int[][] arr = {
//                {1, 2}, {2, 3}, {3, 4}, {4, 5}
//        };

        int[][] arr = {
                {-2147483646, -2147483645}, {2147483646, 2147483647}
        };

        System.out.println(findMinArrowShots(arr));
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 1) return 1;
        if (points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] < b[1]) return -1;
                return 1;
            }
        });
        int end = points[0][1];
        int result = 1;
        for (int i = 1; i < points.length; i++) {
            int[] a = points[i];
            if (end < a[0]) {
                end = a[1];
                ++result;
            }
        }
        return result;
    }
}
