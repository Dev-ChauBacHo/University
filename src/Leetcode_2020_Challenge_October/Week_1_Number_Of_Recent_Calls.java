package Leetcode_2020_Challenge_October;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Week_1_Number_Of_Recent_Calls {
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        int[] arr = {1, 100, 3001, 3002};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(recentCounter.ping(arr[i]));
        }
    }

    public static class RecentCounter {
        public Queue<Integer> queue;

        public RecentCounter() {
            this.queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.add(t);
            while (queue.peek() < (t - 3000)) {
                queue.remove();
            }
            return queue.size();
        }
    }

}
