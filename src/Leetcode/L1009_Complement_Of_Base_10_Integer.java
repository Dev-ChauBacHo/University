package Leetcode;

public class L1009_Complement_Of_Base_10_Integer {
    public static void main(String[] args) {
        System.out.println(bitwiseComplement(608863042));
    }
    public static int bitwiseComplement(int N) {
        if (N == 0) return 1;
        int[] arr = {1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823};
        for (int i = 0; i < arr.length - 1; i++) {
            if (N > arr[i] && N <= arr[i+1]) {
                return arr[i+1] - N;
            }
        }
        return 0;
    }
}
