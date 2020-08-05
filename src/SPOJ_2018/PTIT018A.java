package SPOJ_2018;

import java.util.Scanner;

public class PTIT018A {
    private static final Scanner reader = new Scanner(System.in);
    private static final int MAX = 1000001;
    private static final boolean[] isPrime = new boolean[MAX];

    public static void main(String[] args) {
        int T = reader.nextInt();
        int L, R;
        SangNguyenTo();
        for (int k = 1; k <= T; k++) {
            int result = 0;
            L = reader.nextInt();
            R = reader.nextInt();

            for (int i = L; i <= R; i++) {
                if (isPrime[i] && (i + 6) <= R && isPrime[i + 6]) {
                    ++result;
                }
            }

            System.out.println(result);
        }
    }

    private static void SangNguyenTo() {
        for (int i = 1; i < MAX; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i < MAX; i++) {
            if (isPrime[i]) {
                int j = 2;
                int mul = i * j;
                while (mul < MAX) {
                    isPrime[mul] = false;
                    ++j;
                    mul = i * j;
                }
            }
        }
    }
}
