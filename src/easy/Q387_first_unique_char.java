package easy;

import java.util.ArrayList;
import java.util.HashMap;

public class Q387_first_unique_char {

	// https://leetcode.com/problems/first-unique-character-in-a-string/
	public static int firstUniqChar(String s) {
		if (s == null || s.length() == 0)
			return -1;
		HashMap<Character, Integer> cache = new HashMap<Character, Integer>();
		ArrayList<Character> keys = new ArrayList<Character>();
		int index = -1;
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (cache.containsKey(c)) {
				cache.put(c, -1);
			} else {
				keys.add(c);
				cache.put(c, i);
			}
		}
		for (int i = 0; i < keys.size(); i++) {
			index = cache.get(keys.get(i));
			if (index >= 0) {
				return index;
			}
		}
		return index;
	}

	public static int firstUniqChar2(String s) {
		if (s == null || s.length() == 0)
			return -1;
		int[] freq = new int[256];
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			freq[chars[i]]++;
		}
		for (int i = 0; i < chars.length; i++) {
			if (freq[chars[i]] == 1) {
				return i;
			}
		}
		return -1;
	}

	public static int firstUniqChar3(String s) {
		if (s == null || s.length() == 0)
			return -1;
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (s.indexOf(c) == s.lastIndexOf(c)) {
				return i;
			}
		}
		return -1;
	}

	public static int firstUniqChar4(String s) {
		if (s == null || s.length() == 0)
			return -1;
		int len = s.length();
		int slow = 0, fast = 1;
		int[] count = new int[256];
		char[] chars = s.toCharArray();
		int total = 0;

		count[chars[slow]]++;
		while (fast < len) {
			count[chars[fast]]++;
			if (chars[fast] == chars[slow]) {
				if (++total == 26)
					return -1;
				while (slow < len && count[chars[slow]] > 1)
					slow++;
				if (slow >= len)
					return -1;
			}
			if (count[chars[slow]] == 0) {
				count[chars[slow]]++;
			}
			if (slow > fast)
				fast = slow;
			fast++;
		}
		return slow;
	}

	public static int firstUniqChar5(String s) {
		if (s == null || s.length() == 0)
			return -1;
		int len = s.length();
		int[] index = new int[26];
		int off;
		int i = 1;
		int total = 0;
		for (char c : s.toCharArray()) {
			off = c - 'a';
			if (index[off] == 0) {
				index[off] = i;
			} else if (index[off] > 0) {
				if (++total > 26)
					return -1;
				index[off] = -1;
			}
			i++;
		}
		int ret = len + 1;
		for (int j : index) {
			if (j > 0) {
				ret = Math.min(ret, j);
			}
		}
		return ret == len + 1 ? -1 : ret - 1;
	}

	public static void main(String[] args) {
		System.out.println(firstUniqChar5("leetcode"));
		System.out.println(firstUniqChar5("loveleetcode"));
		System.out.println(firstUniqChar5("aaaaaaaaaaaaaaaaaaaaaaaaaaaaab"));
	}

}
