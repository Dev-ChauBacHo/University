package PTIT_Practice;
import java.util.Scanner;

public class P201PROH {
    private static final Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        int T = reader.nextInt();
        for (int t = 1; t <= T; t++) {
            int A = reader.nextInt();
            int B = reader.nextInt();
            System.out.println(queue(A, B));

        }
    }
    private static String queue(int a, int b) {
        if (a == 1 && b > 1) return "NO";
        if (a == 2 && b > 3) return "NO";
        if (a == 3 && b > 3) return "NO";
        return "YES";
    }
}
