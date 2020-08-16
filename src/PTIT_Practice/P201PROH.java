package PTIT_Practice;
import java.util.LinkedList;
import java.util.Queue;
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
        if (a >= b) return "YES";
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (u == b) return "YES";
            int temp;

            temp = 3 * u / 2;
            if (u % 2 == 0 && temp != a && u < b)
                queue.add(temp);

            temp = u - 1;
            if (u > 1 && temp != a)
                queue.add(temp);


        }
        return "NO";
    }
}
