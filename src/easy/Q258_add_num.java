package easy;



//https://leetcode.com/problems/add-digits/
public class Q258_add_num {
	public static int addDigits2(int num) {
		int tmp;
		while(num>9){
			tmp=0;
			String[] nums = Integer.toString(num).split("");
			for(int i=0; i<nums.length;i++){
				tmp+=Integer.parseInt(nums[i]);
			}
			num=tmp;
		}
		return num;
	}
	
	public static int addDigits(int num){
		if(num==0)
			return num;
		int rem = num%9;
		return rem==0?9:rem;
	}
	
	public static int addDigits3(int num){
		return 1+(num-1)%9;
	}
	
	
	public static void main(String[] args){
		System.out.println(addDigits3(89));
		System.out.println(-1%9);
		
	}
	
}
