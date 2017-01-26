package easy;

import java.util.Arrays;

public class Q014_longest_common_prefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }
        return pre;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0)
            return "0";
        if (strs.length == 1)
            return strs[0];
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();
        for (int i = 0; i < first.length && i < last.length; i++) {
            if (first[i] != last[i])
                break;
            sb.append(first[i]);
        }
        return new String(sb);
    }

    public static String longestCommonPrefix3(String[] strs) {
        if (strs.length == 0 || strs == null)
            return "";
        if (strs.length == 1)
            return strs[0];
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length()
                        || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = { "aaaa", "aaa", "aaaaaa" };
        System.out.println(longestCommonPrefix(strs));
        // System.out.println(longestCommonPrefix2(strs));
        System.out.println(longestCommonPrefix3(strs));
    }
}
