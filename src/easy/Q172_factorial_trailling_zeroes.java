package easy;

public class Q172_factorial_trailling_zeroes {
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

    public static int trailingZeroesR(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroesR(n / 5);
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(25));
        System.out.println(trailingZeroesR(25));
    }
}
