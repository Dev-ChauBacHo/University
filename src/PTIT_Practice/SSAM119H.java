//WA
package PTIT_Practice;

import java.util.Scanner;

public class SSAM119H {
    private static final Scanner reader = new Scanner(System.in);
    private static final int mod = 5;

    public static void main(String[] args) {
        int T = reader.nextInt();
        reader.nextLine();
        for (int t = 1; t <= T; t++) {
            int result = 1;
            String n = reader.nextLine();
            if ((int) n.charAt(n.length() - 1) % 2 == 0) {
                int sum = 1 + multiple(2, n) + multiple(3, n) + multiple(4, n);
                result = sum % 5;
            } else result = 0;
            System.out.println(result);
        }
    }

    private static int multiple(int a, String b) {
        if (b.equals("0")) return 1 % mod;
        int temp = multiple(a, divideLargeNumberFor2(b));
        if ((int) b.charAt(b.length() - 1) % 2 == 0) return temp * temp % mod;
        else return temp * temp * a % mod;
    }

    private static String divideLargeNumberFor2(String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = 0;
        if (b.length() == 1) {
            int temp = b.charAt(i) - '0';
            return temp/2 + "";
        }
        if (b.charAt(0) == '1') {
            carry = 1;
            i = 1;
        }
        for (; i < b.length(); i++) {
            int temp = b.charAt(i) - '0';
            int x = 10 * carry + temp;
            if (x % 2 == 1) carry = 1;
            else carry = 0;
            result.append(x/2);
        }
//        System.out.println(result.toString());
        return result.toString();
    }
}
