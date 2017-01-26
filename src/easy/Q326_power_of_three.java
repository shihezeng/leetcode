package easy;

//https://leetcode.com/problems/power-of-three/
public class Q326_power_of_three {
    public static boolean isPowerOfThree(int n) {
        if (n < 1)
            return false;
        if (n == 1)
            return true;
        return n % 3 == 0 && isPowerOfThree(n / 3);
    }

    public static boolean isPowerOfThree2(int n) {
        if (n > 1) {
            while (n % 3 == 0) {
                n /= 3;
            }
        }
        return n == 1;
    }

    public static boolean isPowerOfThree3(int n) {
        int maxPowerOfThree = (int) Math.pow(3,
                (int) (Math.log(0x7fffffff) / Math.log(3)));
        return n > 0 && maxPowerOfThree % n == 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println(i + ":" + isPowerOfThree3(i));
        }
        System.out.println(Math.pow(3,19));
        System.out.println(Math.pow(3,19)>Integer.MAX_VALUE);
    }
}
