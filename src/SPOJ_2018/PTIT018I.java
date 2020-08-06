package SPOJ_2018;

import java.util.Scanner;

public class PTIT018I {
    public static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        int T = reader.nextInt();
        for (int t = 1; t <= T; t++) {
            int a = reader.nextInt();
            int b = reader.nextInt();
            int c = reader.nextInt();
            int N = reader.nextInt();

            System.out.println(result(a, b, c, N));
        }
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    private static long result(int a, int b, int c, int n) {
        long lcm = lcm(a, b);
        lcm = lcm(lcm, c);
        int i = 1;
        while (countNumber(lcm) < n) {
            lcm /= i;
            i++;
            lcm *= i;
        }
        if (countNumber(lcm) != n) return -1;
        return lcm;
    }

    private static int countNumber(long a) {
        int count = 0;
        while (a != 0) {
            ++count;
            a /= 10;
        }
        return count;
    }
}
