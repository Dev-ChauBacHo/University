package Leetcode_2020_Challenge_October;

public class Week_2_Best_Time_To_Buy_And_Sell_Stock_IV {
    private static int result = 0;
    public static void main(String[] args) {
//        int[] prices = {3,2,6,5,0,3};
//        int[] prices = {1,3,2,5,3,6,5,0,3};
        int[] prices = {2, 4, 1};
        int k = 2;
        System.out.println(maxProfit(k, prices));
    }

    private static int maxProfit(int k, int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            backTrack(prices, k, i, 0, 0);
        }
        return result;
    }

    private static void backTrack(int[] prices, int k, int start, int trans, int profit) {
        System.out.print(prices[start] + " ");
        result = Math.max(result, profit);
        if (trans == k) {
            System.out.println(profit);
            return;
        }
        for (int i = start + 1; i < prices.length; i++) {
            int amount = prices[i] - prices[start];
            if (amount > 0) {
                trans++;
                profit += amount;
                backTrack(prices, k, i, trans, profit);
                System.out.print(" +++ ");
                trans--;
                profit -= amount;
            } else {
                start = i;
            }
        }
    }
}
