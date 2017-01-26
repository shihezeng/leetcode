package easy;

import java.util.HashMap;

public class Q205_isomorphic_string {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int n = s.length();
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
        for (int i = 0; i < n; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sMap.containsKey(sChar) != tMap.containsKey(tChar)) {
                return false;
            } else if (sMap.containsKey(sChar)) {
                if (sMap.get(sChar) != tMap.get(tChar)) return false;
            } else {
                sMap.put(sChar, i);
                tMap.put(tChar, i);
            }
        }
        return true;
    }

    public static boolean isIsomorphic2(String s, String t) {
        int[] sMap = new int[128];
        int[] tMap = new int[128];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sMap[sChar] != tMap[tChar]) return false;
            else sMap[sChar] = tMap[tChar] = i + 1;

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("aa", "ab"));
        System.out.println(isIsomorphic("aba", "baa"));
        System.out.println(isIsomorphic("", ""));
        System.out.println("===========");
        System.out.println(isIsomorphic2("egg", "add"));
        System.out.println(isIsomorphic2("foo", "bar"));
        System.out.println(isIsomorphic2("paper", "title"));
        System.out.println(isIsomorphic2("aa", "ab"));
        System.out.println(isIsomorphic2("aba", "baa"));
        System.out.println(isIsomorphic2("", ""));
    }

}
