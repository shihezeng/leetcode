package easy;

public class Q342_power_of_four {
    // https://leetcode.com/problems/power-of-four/
    // https://discuss.leetcode.com/topic/42914/1-line-c-solution-without-confusing-bit-manipulations
    public static boolean isPowerOfFourI(int num) {
        if (num > 0) {
            while (num % 4 == 0) {
                num /= 4;
            }
        }
        return num == 1;
    }

    public static boolean isPowerOfFourS(int num) {
        return Integer.toString(num, 4).matches("10*");
    }

    public static boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) > 0;
    }

    public static boolean isPowerOfFourM(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }

    public static void main(String[] args) {
        for (int i = -4; i < 100000; i++) {
            if (isPowerOfFourI(i) != isPowerOfFour(i)) {
                System.out.println(i + ":" + isPowerOfFourI(i) + "="
                        + isPowerOfFour(i));
            }
        }
    }

}
