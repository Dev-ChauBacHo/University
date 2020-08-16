package PTIT_Practice;
import java.util.Scanner;

public class P201PROD {
    private static final Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        int T = reader.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = reader.nextInt();
            System.out.println(findAllResult(N));
        }
    }

    private static String findAllResult(int N) {
        int num8 = N / 4 + 1;
        if (N % 4 == 0) num8--;
        StringBuilder s = new StringBuilder();
        s.append("9".repeat(N - num8));
        s.append("8".repeat(num8));
        return s.toString();
    }
}
