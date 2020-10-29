package Leetcode_2020_Challenge_October;

public class Week_5_Maximize_Distance_To_Closest_Person {

    public static void main(String[] args) {
        int[] seats = {0,0,0,1,0,0,0,1,0,0,0,0,1,1,0,0,0,1};
        System.out.println(maxDistToClosest(seats));
    }

    public static int maxDistToClosest(int[] seats) {
        int maxAtStart = 0;
        int maxAtEnd = 0;
        int maxSpace;
        int countZero = 0;
        int i;
        for (i = 0; i < seats.length; i++) {
            if (seats[i] == 0) ++countZero;
            else break;
        }
        maxAtStart = countZero;
        maxSpace = maxAtStart;
        for (; i< seats.length; i++) {
            if (seats[i] == 1) {
                maxSpace = Math.max(maxSpace, countZero);
                countZero = 0;
            } else {
                ++countZero;
                if (i == seats.length - 1) {
                    maxAtEnd = countZero;
                    maxSpace = Math.max(maxSpace, countZero);
                }
            }
        }

        return Math.max(Math.max(maxAtStart, maxAtEnd), (maxSpace + 1) / 2);
    }
}
