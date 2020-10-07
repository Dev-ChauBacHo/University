package PTIT_Practice;

import java.util.Scanner;

public class P203PROJ {
    private static final Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        int T = reader.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = reader.nextInt();
            if (n == 1) System.out.println("Shin");
            else if (n == 2) System.out.println("Lin");
            else {
                if (n % 2 == 1) System.out.println("Lin");
                else {
                    System.out.println(findWinner(n));
                }
            }
        }
    }


    private static String findWinner(int n) {
        int countTwo = 0, countOdd = 0;
        int divisor = 3;
        while (n % 2 == 0) {
            countTwo++;
            n /= 2;
            if (countTwo > 1) break;
        }

        while (n > 1) {
            if (n % divisor == 0) {
                ++countOdd;
                n /= divisor;
            } else {
                divisor += 2;
            }
            if (countOdd > 1) break;
        }

        if (countTwo == 1) {
            if (countOdd == 1) return "Shin";
            else return "Lin";
        } else {
//            if (countOdd == 1) return "Lin";
//            else return "Shin";
            if (countOdd == 0) return "Shin";
            return "Lin";
        }
    }
}
