package Leetcode_2020_Challenge_November;

public class Week_2_Valid_Square {
    public static void main(String[] args) {
        int[] p1 = {0,0}, p2 = {1,1}, p3 = {1,0}, p4 = {0,1};
        System.out.println(validSquare(p1, p2, p3, p4));
    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        //Check if there are 2 (or more) point has the same coordinates
        if (isTheSamePoint(p1, p2) || isTheSamePoint(p1, p3) || isTheSamePoint(p1, p4) ||
                isTheSamePoint(p2, p3) || isTheSamePoint(p2, p4) || isTheSamePoint(p3, p4)) {
            return false;
        }
        long[] squareOfLengths = {countSquare(p1, p2), countSquare(p1, p3), countSquare(p1, p4),
                                    countSquare(p2, p3), countSquare(p2, p4), countSquare(p3, p4)};
        long x = squareOfLengths[0], y = -1;
        for (long i: squareOfLengths) {
            if (i != x) {
                if (y == -1) y = i;
                else {
                    if (i != y) return false;
                }
            }
        }
        return x * 2 == y || y * 2 == x;
    }

    private static long countSquare(int[] p1, int[] p2) {
        return (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
    }

    private static boolean isTheSamePoint(int[] p1, int[] p2) {
        return (p1[0] == p2[0]) && (p1[1] == p2[1]);
    }
}
