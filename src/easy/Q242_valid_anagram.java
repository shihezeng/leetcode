package easy;

import java.util.HashMap;

//https://leetcode.com/problems/valid-anagram/
public class Q242_valid_anagram {
	public static boolean isAnagram(String s, String t) {
		if (s == null || t == null || s.length() != t.length())
			return false;
		int[] cache = new int[256];
		for (char c : s.toCharArray()) {
			cache[c]++;
		}
		for (char c : t.toCharArray()) {
			if (--cache[c] < 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAnagram2(String s, String t) {
		if (s == null || t == null || s.length() != t.length())
			return false;
		HashMap<Character, Integer> cache = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			cache.put(c, cache.getOrDefault(c, 0) + 1);
		}
		for (char c : t.toCharArray()) {
			if (cache.getOrDefault(c, 0) > 0) {
				cache.put(c, cache.get(c)-1);
			}else{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("ba", "ab"));
		System.out.println(isAnagram2("ba", "ab"));
		System.out.println(new Character('0').hashCode());
	}
}
