package easy;

public class Q231_power_of_two {
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        for (int i = -1; i < 20; i++) {
            System.out.println(i + ":" + isPowerOfTwo(i));
        }
    }
}
