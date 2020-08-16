package PTIT_Practice;

import java.util.ArrayList;
import java.util.Scanner;

public class P201PROG {
    private static final Scanner reader = new Scanner(System.in);
    private static final ArrayList<Long> fiboArr = new ArrayList<>();
    public static void main(String[] args) {
        findAllFibonacci();
//        for (Integer i : fiboArr) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        int N = reader.nextInt();
        System.out.println(fiboArr.get(N));

    }

    private static void findAllFibonacci() {
        long temp1 = 0, temp2 = 1;
        fiboArr.add((long) 0);
        fiboArr.add((long) 1);
        for (int i = 2; i <= 90; i++) {
            long t = temp2;
            temp2 += temp1;
            temp1 = t;
            fiboArr.add(temp2);
        }
    }
}
