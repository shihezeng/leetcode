package easy;

//https://leetcode.com/problems/reverse-string/
public class Q344_reverse_string {
	public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left=0, right = s.length()-1;
        char tmp;
        while(left<right){
        	tmp=chars[left];
        	chars[left]=chars[right];
        	chars[right]=tmp;
        	left++;
        	right--;
        }
        return new String(chars);
    }
	
	public static void main(String[] args){
		System.out.println(reverseString("hello"));
	}
}
