package easy;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//https://en.wikipedia.org/wiki/Maximum_subarray_problem
//https://discuss.leetcode.com/topic/19853/kadane-s-algorithm-since-no-one-has-mentioned-about-this-so-far-in-case-if-interviewer-twists-the-input
public class Q121_best_time_to_buy_n_sell {
    public static int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - min);
            }
        }
        return profit;
    }

    public static int maxProfitDiff(int[] prices) {
        int curMax = 0, maxSoFar = 0;
        for (int i = 0; i < prices.length; i++) {
            curMax = Math.max(0, curMax + prices[i]);
            maxSoFar = Math.max(maxSoFar, curMax);
//            System.out.println(curMax+","+maxSoFar);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        // System.out.println(maxProfit(new int[] {1}));
        System.out.println(maxProfit(new int[] { 7, 2, 5, 6, 1, 6 }));
        System.out.println(maxProfitDiff(new int[] { -5, 3, 1, -5, 5 }));
    }
}
