package easy;

import java.util.HashMap;
import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/
public class Q020_valid_parenthesis {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if (s == null || s.length() % 2 != 0)
            return false;
        HashMap<Character, Character> pair = new HashMap<>();
        pair.put(')', '(');
        pair.put(']', '[');
        pair.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if (stack.pop() != pair.get(c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid(")}{({))[{{[}"));
        System.out.println(isValid("()"));
        System.out.println(isValid("([)]"));
    }
}
