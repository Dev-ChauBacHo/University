package PTIT_Practice;

import java.util.Scanner;

public class P201PROJ {
    private static final Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        int T = reader.nextInt();
        for (int t = 1; t <= T; t++) {
            long A = reader.nextInt();
            long B = reader.nextInt();

//            int numberWithAll9OfA = String.valueOf(A+1).length()-1;
            long numberWithAll9OfB = String.valueOf(B+1).length()-1;

            long result = A * numberWithAll9OfB; // + B * numberWithAll9OfA;
            System.out.println(result);
        }
    }
}
