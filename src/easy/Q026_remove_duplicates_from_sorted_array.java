package easy;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class Q026_remove_duplicates_from_sorted_array {
    public static int removeDuplicates(int[] nums) {
        int index=0;
        for(int i=1; i<nums.length;i++){
            if(nums[i]!=nums[index]){
                nums[++index]=nums[i];
            }
        }
        return index+1;
    }
}
