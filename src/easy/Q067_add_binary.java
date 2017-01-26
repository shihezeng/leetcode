package easy;

//https://leetcode.com/problems/add-binary/
public class Q067_add_binary {

    public static String addBinary(String a, String b) {
        if (a == null || b == null)
            return a == null ? b : a;
        if (a.length() < b.length())
            return addBinary(b, a);
        char[] chars = a.toCharArray();
        int i = a.length();
        int j = b.length();
        boolean carry = false;
        while (j > 0) {
            char aChar = chars[--i];
            char bChar = b.charAt(--j);
            if (carry) {
                if (aChar == '0' && bChar == '0') {
                    chars[i] = '1';
                    carry = false;
                } else if (aChar == '1' && bChar == '0') {
                    chars[i] = '0';
                }
            } else {
                if (bChar == '1') {
                    if (aChar == '0') {
                        chars[i] = '1';
                    } else if (aChar == '1') {
                        chars[i] = '0';
                        carry = true;
                    }
                }
            }
        }
        while (carry && i-- > 0) {
            if (chars[i] == '0') {
                chars[i] = '1';
                carry = false;
            } else if (chars[i] == '1') {
                chars[i] = '0';
            }
        }
        return carry ? "1" + new String(chars) : new String(chars);
    }

    public static String addBinary2(String a, String b) {
        if (a == null || a.isEmpty())
            return b;
        if (b == null || b.isEmpty())
            return a;
        int i = a.length(), j = b.length(), carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i> 0 || j> 0 || carry == 1) {
            int sum = carry;
            sum += --i >= 0 ? a.charAt(i) - '0' : 0;
            sum += --j >= 0 ? b.charAt(j) - '0' : 0;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary(
                "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary2("1010", "1011"));
    }

}
