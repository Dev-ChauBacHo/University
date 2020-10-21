package Leetcode_2020_Challenge_October;

import java.util.Arrays;

public class Week_3_Asteroid_Collision {
    public static void main(String[] args) {
//        int[] asteroids = {-2, 2, 1, -2};
        int[] asteroids = {5, 10, -5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        int[] stack = new int[asteroids.length + 1];
        int end = -1;
        for (int newStar : asteroids) {
            if (end == -1) { // if the stack is empty
                stack[++end] = newStar; //push
            } else if (newStar > 0 || (newStar < 0 && stack[end] < 0)) {
                stack[++end] = newStar;
            } else if (newStar < 0 && stack[end] > 0) {
                int oldStar = stack[end];
                if (newStar + oldStar == 0) --end;
                else {
                    while (oldStar > 0 && (newStar + oldStar < 0)) {
                        --end;
                        if (end != -1) {
                            oldStar = stack[end];
                        } else {
                            break;
                        }
                    }
                    if (newStar + oldStar == 0 && end != -1) --end;
                    else if (end == -1 || (oldStar + newStar) < 0) stack[++end] = newStar;
                }
            }
        }

        if (end == -1) return new int[0];
        int[] result = new int[end+1];
        for (int i = 0; i <= end; i++) {
            result[i] = stack[i];
        }

        return result;
    }
}
