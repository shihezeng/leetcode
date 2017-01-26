package easy;

//https://leetcode.com/problems/house-robber/
public class Q198_house_robber {
    public static int rob(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sum1 = Math.max(sum1 + nums[i], sum2);
            } else {
                sum2 = Math.max(sum2 + nums[i], sum1);
            }
        }
        return Math.max(sum1, sum2);
    }

    public static int rob2(int[] nums) {
        int prevNo = 0, prevYes = 0;
        for (int num : nums) {
            int tmp = prevNo;
            prevNo = Math.max(prevYes, prevNo);
            prevYes = tmp + num;
        }
        return Math.max(prevNo, prevYes);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[] { 2, 1, 1, 2 }));
        System.out.println(rob2(new int[] { 2, 1, 1, 2 }));
    }
}
