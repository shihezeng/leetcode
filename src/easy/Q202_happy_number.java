package easy;

import java.util.HashSet;
import java.util.Set;

///https://leetcode.com/problems/happy-number/
//https://discuss.leetcode.com/topic/12587/my-solution-in-c-o-1-space-and-no-magic-math-property-involved
//https://discuss.leetcode.com/topic/22265/fastest-java-code-so-far-with-comments
//https://discuss.leetcode.com/topic/55000/42-is-the-answer
public class Q202_happy_number {
    static Set<Integer> happyNums = new HashSet<Integer>();
    static Set<Integer> unhappyNums = new HashSet<Integer>();

    public static boolean isHappy(int n) {
        Set<Integer> tmp = new HashSet<Integer>();
        happyNums.add(1);
        return isHappy(n, tmp, happyNums, unhappyNums);
    }

    public static boolean isHappy(int n, Set<Integer> tmp,
            Set<Integer> happyNums, Set<Integer> unhappyNums) {
        if (happyNums.contains(n)) {
            happyNums.addAll(tmp);
            return true;
        }
        if (unhappyNums.contains(n) || !tmp.add(n)) {
            unhappyNums.addAll(tmp);
            return false;
        }
        return isHappy(next(n), tmp, happyNums, unhappyNums);
    }

    public static int next(int n) {
        int result = 0;
        while (n > 0) {
            int remainder = n % 10;
            result += remainder * remainder;
            n /= 10;
        }
        return result;
    }

    public static boolean isHappy2(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while (set.add(n)) {
            if (n == 1) {
                return true;
            }
            n = next(n);
        }
        return false;
    }

    public static boolean isHappy3(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = next(slow);
            fast = next(next(fast));
            if (slow == 1 || fast == 1) {
                return true;
            }
        } while (slow != fast);
        return false;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            if (isHappy(i) != isHappy2(i))
                System.out.println(i + " happy=" + isHappy(i) + ", "
                        + isHappy2(i));
            System.out.println("==============");
        }
    }

}
