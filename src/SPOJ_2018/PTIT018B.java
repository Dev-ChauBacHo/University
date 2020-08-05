package SPOJ_2018;

import java.util.Arrays;
import java.util.Scanner;

public class PTIT018B {
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        int T = reader.nextInt();
        int N;
        for (int k = 1; k <= T; k++) {
            boolean result = true;
            N = reader.nextInt();
            int[] A = new int[N+1];
            int[] B = new int[N+1];
            for (int i = 0; i < N; i++) {
                A[i] =  reader.nextInt();
            }
            for (int i = 0; i < N; i++) {
                B[i] =  reader.nextInt();
            }
            Arrays.sort(A);
            Arrays.sort(B);
            for (int i = 0; i < N; i++) {
                if (A[i] > B[i]) {
                    result = false;
                    break;
                }
            }
            if (result) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
