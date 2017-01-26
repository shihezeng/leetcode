package easy;

//https://leetcode.com/problems/reverse-integer/
public class Q007_revese_integer {
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int tail = x % 10;
            int newRev = rev * 10 + tail;
            if ((newRev - tail) / 10 != rev) {
                return 0;
            }
            rev = newRev;
            x /= 10;
        }
        return rev;
    }

    public static int reverse2(int x) {
        long rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int)rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse2(-2147483648));
//        System.out.println(reverse2(1463847412));

    }
}
