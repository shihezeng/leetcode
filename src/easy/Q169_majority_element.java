package easy;

import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/majority-element/
//https://discuss.leetcode.com/topic/8692/o-n-time-o-1-space-fastest-solution
public class Q169_majority_element {
	public static int majorityElement(int[] nums) {
		if (nums == null)
			return -1;
		int length = nums.length;
		HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
		for (int n : nums) {
			cache.put(n, cache.getOrDefault(n, 0) + 1);
			if (cache.get(n) > length/ 2) {
				return n;
			}
		}
		return -1;
	}

	public static int majorityElement2(int[] nums) {
		if (nums == null)
			return -1;
		int major = nums[0], count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (count == 0) {
				count++;
				major = nums[i];
			} else if (nums[i] == major) {
				count++;
			} else {
				count--;
			}
		}
		return major;
	}
	
	public static int majorityElement3(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}

	public static void main(String[] args) {
		int[] array1 = {1};
		int[] array2 = {1, 2, 2};
		int[] array3 = {1, 2, 2, 1};
		System.out.println(majorityElement(array1));
		System.out.println(majorityElement(array2));
		System.out.println(majorityElement(array3));
		System.out.println(majorityElement2(null));
	}
}
