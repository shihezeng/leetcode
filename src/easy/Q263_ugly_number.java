package easy;

public class Q263_ugly_number {

    public static boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        for (int n : new int[] { 5, 3, 2 }) {
            while (num % n == 0) {
                num /= n;
            }
        }
        return num == 1;
    }

    public static void main(String[] args) {
        for (int i = -10; i < 101; i++) {
            System.out.println(i + " ugly? " + isUgly(i));
        }
    }
}
