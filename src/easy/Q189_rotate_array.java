package easy;

import java.util.Arrays;

public class Q189_rotate_array {

    public static void rotate(int[] nums, int k) {
        int[] dup = new int[nums.length * 2];
        k = k % nums.length;
        for (int i = 0; i < nums.length * 2; i++) {
            dup[i] = nums[i % nums.length];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = dup[nums.length - k + i];
        }
    }

    public static void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int[] nums2 = nums.clone();
        System.out.println(Arrays.toString(nums));
        rotate(nums, 13);
        rotate2(nums2, 13);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums2));
    }

}
