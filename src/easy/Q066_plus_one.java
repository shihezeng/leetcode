package easy;

import java.util.Arrays;

//https://leetcode.com/problems/plus-one/
public class Q066_plus_one {
    public static int[] plusOne(int[] digits) {
        if (digits == null)
            return null;
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 9, 9 };
        System.out.println(Arrays.toString(plusOne(array)));
    }
}
