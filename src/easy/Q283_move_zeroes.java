package easy;

import java.util.Arrays;

//https://leetcode.com/problems/move-zeroes/
public class Q283_move_zeroes {
	public static void moveZeroes(int[] nums) {
		int cur = 0;
		for (int num : nums) {
			if (num != 0)
				nums[cur++] = num;
		}
		while (cur < nums.length) {
			nums[cur++] = 0;
		}
	}

	public static void main(String[] args) {
		int[] array = {1, -1, 2, 2, 12};
		int[] array2 = {0, 0, 0, 2, 2, 3, 0};

		System.out.println(Arrays.toString(array));
		moveZeroes(array);
		System.out.println(Arrays.toString(array));

		System.out.println(Arrays.toString(array2));
		moveZeroes(array2);
		System.out.println(Arrays.toString(array2));
	}

}
