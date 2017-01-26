package easy;


//https://leetcode.com/problems/find-the-difference/
public class Q389_find_diff {
	public static char findTheDifference(String s, String t) {
		char c = 0;
		for(int i=0;i<s.length();i++){
			c^=s.charAt(i)^t.charAt(i);
		}
		c^=t.charAt(t.length()-1);
		return c;
	}
	
	public static char findTheDifference2(String s, String t) {
		char c1 = 0;
		char c2 = 0;
		for(int i=0;i<s.length();i++){
			c1+=s.charAt(i);
			c2+=s.charAt(i);
		}
		c2+=t.charAt(t.length()-1);
		return (char) (c2-c1);
	}
	
	public static void main (String[] args){
		System.out.println(findTheDifference("abcd", "abcde"));
		System.out.println(findTheDifference2("abcd", "abcde"));
	}
}
