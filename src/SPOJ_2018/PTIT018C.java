package SPOJ_2018;

import java.util.ArrayList;
import java.util.Scanner;
/*
    https://vn.spoj.com/PTIT/problems/PTIT018C/
 */
public class PTIT018C {
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        int T = reader.nextInt();
        reader.nextLine();
        for (int t = 1; t <= T; t++) {
            String a = reader.next();
            long b = reader.nextLong();
            long m = reader.nextLong();
            long mod_A_for_M = largeNumber_getMod(a, m);
            long result = multiple(mod_A_for_M, b, m) % m;
            System.out.println(result);
        }
    }

    private static long largeNumber_getMod(ArrayList<Integer> v, long m) {
        long carry = 0;
        long divisor;
        while (!v.isEmpty()) {
            int temp = v.get(0);
            divisor = carry * 10 + temp;
            carry = divisor % m;
            v.remove(0);
        }
        return carry;
    }


    private static long multiple(long a, long b, long mod) {
        if (b == 0) return 1 % mod;
        long temp = multiple(a, b / 2, mod);
        if (b % 2 == 0) return temp * temp % mod;
        else return (temp * temp % mod) * a % mod;
    }

    // This function find the result of: s mod m. With s is a large number
    private static long largeNumber_getMod(String s, long m) {
        long carry = 0;
        long divisor;
        int i = 0;
        while (i < s.length()) {
            int temp = (s.charAt(i) - '0');
            divisor = carry * 10 + temp;
            carry = divisor % m;
            ++i;
        }
        return carry;
    }

    private static ArrayList<Integer> stringToArrayList(String a) {
        ArrayList<Integer> v = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            int temp = (a.charAt(i) - '0');
            v.add(temp);
        }
        return v;
    }
}
