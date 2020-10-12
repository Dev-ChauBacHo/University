package Leetcode_2020_Challenge_October;

import java.util.Stack;

public class Week_2_Remove_Duplicate_Letters {

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("abacb"));
    }

    public static String removeDuplicateLetters(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        boolean[] isAdded = new boolean[26];
        int[] lastPosition = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int temp = (int) s.charAt(i) - 97;
            lastPosition[temp] = i;
        }

        for (int i = 0; i < 26; i++) {
            isAdded[i] = false;
        }

        for (int i = 0; i < s.length(); i++) {
            int newLetter = (int) s.charAt(i) - 97;
            if (stack.isEmpty()) {
                stack.push(newLetter);
                isAdded[newLetter] = true;
            } else {
                int lastAddedLetter = stack.peek();

                while (!stack.isEmpty() && newLetter < lastAddedLetter
                                && lastPosition[lastAddedLetter] > i && !isAdded[newLetter]) {
                    isAdded[lastAddedLetter] = false;
                    stack.pop();
                    if (!stack.isEmpty()) lastAddedLetter = stack.peek();
                }
                if (!isAdded[newLetter]) {
                    stack.push(newLetter);
                    isAdded[newLetter] = true;
                }
            }
            System.out.println(stack.toString());
        }

        while (!stack.isEmpty()) {
            char c = (char) (stack.peek() + 97);
            stack.pop();
            result.append(c);
        }
        return result.reverse().toString();
    }
}

/*
    Note:
    The idea is: Loop the string s
    We try to make the alphabet order by: the new letter need to be:
    if the new letter > the last added letter, the new letter is not added before --> add the new letter
    if the new letter < the last added letter:
        if there is still a last added letter after the new letter in string s
                    --> remove the last added letter then add the new one
        if there isn't --> just add the new one
 */