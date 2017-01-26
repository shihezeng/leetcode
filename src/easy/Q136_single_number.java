package easy;

public class Q136_single_number {
	
	//https://leetcode.com/problems/single-number/
	public static int singleNumber(int[] nums) {
       int result=0;
       for(int i=0; i<nums.length; i++){
    	   result^=nums[i];
       }
       return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {3,4,3,4,6};
		System.out.println(singleNumber(nums));
	}

}
