package easy;

import java.util.Arrays;
//https://leetcode.com/problems/two-sum/
import java.util.HashMap;

public class Q001_two_sum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                result[0]=map.get(target-nums[i]);
                result[1]=i;
                break;
            }
            if (! map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 3,3, 2, 4 };
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

}
