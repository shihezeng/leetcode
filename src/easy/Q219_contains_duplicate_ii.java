package easy;

//https://leetcode.com/problems/contains-duplicate-ii/
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Q219_contains_duplicate_ii {

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				if (Math.abs(map.get(nums[i]) - i) <= k) return true;
			}
			map.put(nums[i], i);
		}
		return false;
	}

	public static boolean containsNearbyDuplicate2(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) set.remove(nums[i - k - 1]);
			if (!set.add(nums[i])) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 1, 3, 7};
		int k = 4;
		System.out.println(containsNearbyDuplicate(nums, k));
	}

}
