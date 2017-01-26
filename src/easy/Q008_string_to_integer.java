package easy;

//https://leetcode.com/problems/string-to-integer-atoi/
public class Q008_string_to_integer {
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        char[] chars = str.toCharArray();
        long result = 0;
        boolean isNegative = false;
        boolean foundFirstValid = false;
        for (char c : chars) {
            if (!foundFirstValid) {
                if (c == ' ') {
                    continue;
                } else if (c == '+') {
                    foundFirstValid = true;
                    isNegative = false;
                } else if (c == '-') {
                    foundFirstValid = true;
                    isNegative = true;
                } else if (isNum(c)) {
                    foundFirstValid = true;
                    result = c - '0';
                } else {
                    return (int) result;
                }
            } else {
                if (isNum(c)) {
                    result = result * 10 + (c - '0');
                    if (result > Integer.MAX_VALUE)
                        break;
                } else {
                    break;
                }

            }
        }
        if (isNegative) {
            result *= -1;
        }
        if (result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        }
        return (int) result;
    }

    private static boolean isNum(char c) {
        if (c - '0' >= 0 && c - '0' <= 9)
            return true;
        return false;
    }

    public static int myAtoi2(String str) {
        if (str == null || str.isEmpty())
            return 0;
        int i = 0;
        long result = 0;
        int sign = 1;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i >= str.length()) {
            return 0;
        }
        if (str.charAt(i) == '+') {
            sign = 1;
            i++;
        } else if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        while (i < str.length()) {
            int tmp = str.charAt(i) - '0';
            if (tmp >= 0 && tmp <= 9) {
                result = result * 10 + tmp;
                if (result > Integer.MAX_VALUE) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else {
                break;
            }
            i++;
        }
        return (int) result * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("       -2147483649"));
        System.out.println(myAtoi2("1"));
    }
}
