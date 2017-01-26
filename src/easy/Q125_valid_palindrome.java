package easy;

//https://leetcode.com/problems/valid-palindrome/
public class Q125_valid_palindrome {

    public static boolean isPalindrome(String s) {
        byte[] cache = createCache();
        if (s == null)
            return false;
        if (s.length() == 0)
            return true;
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            if (cache[chars[i]] == 1 && cache[chars[j]] == 1) {
                if (Character.toLowerCase(chars[i]) == Character
                        .toLowerCase(chars[j])) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            } else {
                if (cache[chars[i]] == 0) {
                    i++;
                }
                if (cache[chars[j]] == 0) {
                    j--;
                }
            }
        }
        return true;
    }

    private static byte[] createCache() {
        byte[] cache = new byte[128];
        for (char a = 'a'; a <= 'z'; a++) {
            cache[a] = 1;
        }
        for (char a = '0'; a <= '9'; a++) {
            cache[a] = 1;
        }
        for (char a = 'A'; a <= 'Z'; a++) {
            cache[a] = 1;
        }
        return cache;
    }

    public static boolean isPalindrome2(String s) {
        if (s == null)
            return false;
        char[] chars = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j;) {
            if (!Character.isLetterOrDigit(chars[i]))
                i++;
            else if (!Character.isLetterOrDigit(chars[j]))
                j--;
            else if (Character.toLowerCase(chars[i++]) != Character
                    .toLowerCase(chars[j--]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(isPalindrome("a:&2332&*a"));
        System.out.println(isPalindrome2("a:&2332&*a"));
    }

}
