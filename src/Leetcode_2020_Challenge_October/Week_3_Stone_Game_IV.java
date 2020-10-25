package Leetcode_2020_Challenge_October;

public class Week_3_Stone_Game_IV {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(winnerSquareGame(n));
    }

    private static boolean winnerSquareGame(int n) {
        boolean[] arr = new boolean[n + 2];
        arr[0] = false;
        for (int i = 0; i <= n; i++) {
            if (!arr[i]) {
                for (int j = 1; i + j * j <= n; j++) {
                    arr[i + j * j] = true;
                }
            }
        }
        return arr[n];
    }
}
