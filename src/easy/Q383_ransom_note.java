package easy;

import java.util.HashMap;

//https://leetcode.com/problems/ransom-note/
//solution: https://discuss.leetcode.com/topic/53864/java-o-n-solution-easy-to-understand/8
public class Q383_ransom_note {
	public static boolean canConstruct(String ransomNote, String magazine) {
		int[] cache = new int[26];
		for (char c : magazine.toCharArray()) {
			cache[c - 'a']++;
		}
		for (char c : ransomNote.toCharArray()) {
			if (--cache[c - 'a'] < 0)
				return false;
		}
		return true;
	}

	public static boolean canConstruct2(String ransomNote, String magazine) {
		HashMap<Character, Integer> cache = new HashMap<Character, Integer>();
		int result = ransomNote.length();
		for (char c : ransomNote.toCharArray()) {
			cache.put(c, cache.getOrDefault(c, 0) + 1);
		}
		for (char c : magazine.toCharArray()) {
			if (cache.containsKey(c) && cache.get(c) > 0) {
				cache.put(c, cache.get(c) - 1);
				result--;
			}
		}
		return result == 0;
	}

	public static void main(String[] args) {
		System.out.println(canConstruct2("a", "b"));
		System.out.println(canConstruct2("aa", "bb"));
		System.out.println(canConstruct2("aa", "aab"));
	}
}
