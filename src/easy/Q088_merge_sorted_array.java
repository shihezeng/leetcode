package easy;

import java.util.Arrays;

//https://leetcode.com/problems/merge-sorted-array/
public class Q088_merge_sorted_array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[m + n + 1] = nums1[m--];
            } else {
                nums1[m + n + 1] = nums2[n--];
            }
        }
        while(n>=0){
            nums1[m+n+1]=nums2[n--];
        }
    }

    public static void main(String[] args) {
//        int[] nums1 = {1,3,6,0,0};
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n=1;
        System.out.println(Arrays.toString(nums1));
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

}
