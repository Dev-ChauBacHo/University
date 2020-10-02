package Leetcode;

public class L1592_Rearrange_Spaces_Between_Words {

    public static String reorderSpaces(String s) {
        // Text is string without spaces
        String text = s.replaceAll("\\s+", "");
        String result = "";
        // arr is an array contains words in s
        String[] arr = s.split("\\s+");
        int words = arr.length;
        int spaces = s.length() - text.length(); // Total spaces
        int i = 0;

        // arr[0] may equal "" if there are more than 1 words and the first character in s is " "
        if (s.charAt(0) == ' ' && words > 1) {
            --words;
            i = 1;
        }
        /* Spaces to divide between words
            If there is only 1 words then all space becomes extra spaces
         */
        int divideSpace = (words == 1) ? 0 : (spaces / (words - 1));
        int extraSpace = (words == 1) ? spaces : (spaces % (words - 1));

        String gap = "";
        for (int x = 1; x <= divideSpace; x++) {
            gap += " ";
        }
        for (; i < arr.length-1; i++) {
            result = result.concat(arr[i] + gap);
        }

        result = result.concat(arr[i]);
        for (int x = 1; x <= extraSpace; x++) {
            result = result.concat(" ");
        }
        return result;
    }
}
