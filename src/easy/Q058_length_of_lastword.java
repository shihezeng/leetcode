package easy;

//https://leetcode.com/problems/length-of-last-word/
public class Q058_length_of_lastword {

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int count = 0;
        boolean lastLetterFound = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (lastLetterFound) {
                    return count;
                }
            } else {
                if (!lastLetterFound) {
                    lastLetterFound = true;
                }
                count++;
            }
        }
        return count;
    }
    
    public static int lengthOfLastWord2(String s){
        return s.trim().length() - s.trim().lastIndexOf(" ")-1;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" "));
        System.out.println(lengthOfLastWord2(" "));
        System.out.println(lengthOfLastWord("a"));
        System.out.println(lengthOfLastWord2("a"));
        System.out.println(lengthOfLastWord("aasd asd "));
        System.out.println(lengthOfLastWord2("aasd asd "));
    }

}
