package easy;

//https://leetcode.com/problems/palindrome-number/
public class Q009_palindrome_number {

    public static boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        for(int i=0; i<xStr.length()/2;i++){
            if(xStr.charAt(i)!=xStr.charAt(xStr.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    
    public static boolean isPalindrome2(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(x).reverse();
        return sb.toString().equals(String.valueOf(x));
    }
    
    public static boolean isPalindrome3(int x) {
        if(x<0 || (x!=0 && x%10==0)) return false;
        int rev=0;
        while(x>rev){
            rev=rev*10+x%10;
            x/=10;
        }
        return x==rev || x==rev/10;
    }

    public static void main(String[] args) {
        long t1=System.currentTimeMillis();
        System.out.println(isPalindrome2(1));
        long t2=System.currentTimeMillis();
        System.out.println(isPalindrome3(1));
        long t3=System.currentTimeMillis();
        System.out.println((t2-t1)+","+(t3-t2));
        
    }

}
