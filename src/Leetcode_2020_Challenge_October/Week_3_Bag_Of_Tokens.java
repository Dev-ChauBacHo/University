package Leetcode_2020_Challenge_October;

import java.util.Arrays;

public class Week_3_Bag_Of_Tokens {
    public static void main(String[] args) {
        int[] tokens = {100,200,300,400};
        System.out.println(bagOfTokensScore(tokens, 200));
    }

    public static int bagOfTokensScore(int[] tokens, int P) {
        if (tokens.length == 0) return 0;
        int score = 0;
        int result = -1;

        Arrays.sort(tokens);

        for (int i = 0, j = tokens.length - 1; i <= j;) {
            if (P >= tokens[i]) {
                System.out.print(P + " ");
                ++score;
                P -= tokens[i];
                System.out.println(tokens[i]);
                ++i;
            } else if (score > 0) {
                System.out.println(i + " " + P);
                score--;
                P += tokens[j];
                --j;
            }
            result = Math.max(result, score);
        }
        result = Math.max(result, score);
        return result;
    }
}
