package PTIT_Practice;

import java.util.Scanner;

public class P201PROF {
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        long N = reader.nextLong();
        long K = reader.nextLong();
        System.out.println(lcm(N, (long) Math.pow(10, K)));
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
}
