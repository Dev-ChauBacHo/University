//Not AC, got Time Limit Exceeded when use ArrayList
//Got WA when use String
package SPOJ_2018;

import java.util.ArrayList;
import java.util.Scanner;

public class PTIT018C {
    private static final Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        int T = reader.nextInt();
        reader.nextLine();
        for (int t = 1; t <= T; t++) {
            String a = reader.next();
            int b = reader.nextInt();
            int m = reader.nextInt();
//            ArrayList<Integer> v = stringToArrayList(a);
//            int mod_A_for_M = largeNumber_getMod(v, m);
            int mod_A_for_M = largeNumber_getMod(a, m);
            int oldMod = mod_A_for_M;
            for (int i = 1; i < b; i++) {
                int newMod = (oldMod * mod_A_for_M) % m;
                oldMod = newMod;
            }
            System.out.println(oldMod);
        }
    }

    private static int largeNumber_getMod(ArrayList<Integer> v, int m) {
        int carry = 0;
        int divisor;
        while (!v.isEmpty()) {
            int temp = v.get(0);
            divisor = carry * 10 + temp;
            carry = divisor % m;
            v.remove(0);
        }
        return carry;
    }

    private static int largeNumber_getMod(String s, int m) {
        int carry = 0;
        int divisor;
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
