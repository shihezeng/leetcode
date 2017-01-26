package easy;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/reverse-vowels-of-a-string/
//https://discuss.leetcode.com/topic/43412/java-standard-two-pointer-solution
//https://discuss.leetcode.com/topic/48150/my-4ms-solution-in-java-beats-98-20
public class Q345_reverse_vowels {
    static Set<Character> vowels = new HashSet<Character>();
    static {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
    }

    public static String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String vowels = "aeiouAEIOU";
        int low = 0;
        int high = s.length() - 1;
        char[] chars = s.toCharArray();
        while (low < high) {
            while (low < high && !vowels.contains(chars[low] + "")) {
                low++;
            }
            while (low < high && !vowels.contains(chars[high] + "")) {
                high--;
            }
            if (low < high) {
                char tmp = chars[low];
                chars[low] = chars[high];
                chars[high] = tmp;
                low++;
                high--;
            }
        }
        return new String(chars);
    }

    public static String reverseVowels2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int low = 0;
        int high = s.length() - 1;
        char[] chars = s.toCharArray();
        while (low < high) {
            while (low < high && !vowels.contains(chars[low])) {
                low++;
            }
            while (low < high && !vowels.contains(chars[high])) {
                high--;
            }
            if (low < high) {
                char tmp = chars[low];
                chars[low] = chars[high];
                chars[high] = tmp;
                low++;
                high--;
            }
        }
        return new String(chars);
    }

    public static String reverseVowels3(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int low = 0;
        int high = s.length() - 1;
        char[] chars = s.toCharArray();
        while (low < high) {
            while (low < high && !isVowel(chars[low])) {
                low++;
            }
            while (low < high && !isVowel(chars[high])) {
                high--;
            }
            if (low < high) {
                char tmp = chars[low];
                chars[low] = chars[high];
                chars[high] = tmp;
                low++;
                high--;
            }
        }
        return new String(chars);
    }

    private static boolean isVowel(char c) {
        switch (c) {
        case 'a':
            return true;
        case 'e':
            return true;
        case 'i':
            return true;
        case 'o':
            return true;
        case 'u':
            return true;
        case 'A':
            return true;
        case 'E':
            return true;
        case 'I':
            return true;
        case 'O':
            return true;
        case 'U':
            return true;
        default:
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels3("hello"));
        System.out.println(reverseVowels3("CCCCCC"));
        System.out.println(reverseVowels3("OE"));
        System.out.println(reverseVowels3(",."));
    }

}
