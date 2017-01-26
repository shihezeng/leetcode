package easy;

//https://leetcode.com/problems/implement-strstr/
public class Q028_implement_strstr {
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j < needle.length()
                    && haystack.charAt(i + j) == needle.charAt(j); j++) {
                if (j == needle.length() - 1)
                    return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
        System.out.println(strStr("asadasd", "asd"));
        System.out.println(strStr("a", ""));
    }

}
