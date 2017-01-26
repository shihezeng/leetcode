package easy;

//https://leetcode.com/problems/climbing-stairs/
//https://discuss.leetcode.com/topic/30638/using-the-fibonacci-formular-to-get-the-answer-directly
public class Q070_climbing_stairs {
    public static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        } else {
            int prev2 = 1;
            int prev1 = 1;
            int cur = 0;
            for (int i = 2; i <= n; i++) {
                cur = prev2 + prev1;
                prev2 = prev1;
                prev1 = cur;
            }
            return cur;
        }
    }

    public static int climbStairs2(int n) {
        int a = 1;
        int b = 1;
        while (n-- > 0) {
            a = (b += a) - a;
        }
        return a;
    }

    public static int climbStairsR(int n) {
        if (n <= 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairsCal(int n) {
        n++;
        double root5 = Math.pow(5, 0.5);
        double phi = (1 + root5) / 2;
        return (int) ((Math.pow(phi, n) - Math.pow(-phi, -n)) / root5);
    }

    public static int climbStairsCal2(int n) {
        n++;
        double phi = (1 + Math.pow(5, 0.5)) / 2;
        return (int) (Math.pow(phi, n) / Math.pow(5, 0.5));
    }

    public static int climbStairsDP(int n) {
        if (n < 2)
            return 1;
        int[] ways = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;
        for (int i = 2; i <= n; i++) {
            ways[i] = ways[i - 2] + ways[i - 1];
        }
        return ways[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 40; i++) {
            System.out.println(i + " stairs=" + climbStairs(i) + ":"
                    + climbStairsDP(i) + " ways");
        }
    }
}
