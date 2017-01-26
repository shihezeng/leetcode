package easy;

import java.util.HashSet;

//https://leetcode.com/problems/contains-duplicate/
public class Q217_contains_duplicate {
	public static boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int num : nums) {
			if (!set.add(num))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] array = {1, 2, 3};
		int[] array1 = {1, 2, 1};
		System.out.println(containsDuplicate(array));
		System.out.println(containsDuplicate(array1));
	}
}
