package SPOJ_2018;

import java.util.Scanner;

public class PTIT018D {
    public static final Scanner reader = new Scanner(System.in);
    private static char[] chars1;
    private static char[] chars2;
    private static int mid;
    public static void main(String[] args) {
        int T = reader.nextInt();
        reader.nextLine();
        for (int t = 1; t <= T; t++) {
            String s = reader.nextLine();
            mid = (s.length() + 1)/2;
            chars1 = new char[mid+1];
            chars2 = new char[mid+1];

            //Divide
            for (int i = 0; i < mid; i++) {
                chars1[i] = s.charAt(i);
                chars2[i] = s.charAt(i+mid);
            }
//            print();
            rotate(chars1);
            rotate(chars2);

//            print();
            for (int i = 0; i < mid; i++) {
                chars1[i] = merge(chars1[i], (int)chars2[i] - 65);
            }

            for (int i = 0; i < mid; i++) {
                System.out.print(chars1[i]);
            }
            System.out.println();
        }
    }

    private static void print() {
        for (int i = 0; i < mid; i++) {
            System.out.print(chars1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < mid; i++) {
            System.out.print(chars2[i] + " ");
        }
        System.out.println();
        System.out.println("___________");
    }

    private static void rotate(char[] chars) {
        int sum = 0;
        for (int i = 0 ; i < mid; i++) {
            sum += ((int)chars[i] - 65);
        }

        for (int i = 0; i < mid; i++) {
            chars[i] = merge(chars[i], sum);
        }
    }

    private static char merge(char x, int y) {
        y = y % 26;
        int newChar = (int)x - 65 + y;
        if (newChar > 25) {
            return (char)(newChar - 26 + 65);
        } else {
            return (char)(newChar + 65);
        }
    }
}
