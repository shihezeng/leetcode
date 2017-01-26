package easy;

//https://leetcode.com/problems/count-and-say/
public class Q038_count_n_say {
    public static String countAndSay(int n) {
        if (n < 1)
            return "1";
        String prev = "1";
        for (int i = 1; i < n; i++) {
            prev = setPrev(prev);
        }
        return prev;
    }

    private static String setPrev(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            char prevC = str.charAt(i);
            int count = 0;
            while (i < str.length() && str.charAt(i) == prevC) {
                count++;
                i++;
            }
            sb.append(count);
            sb.append(prevC);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(-1));
        System.out.println(countAndSay(0));
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
    }
}
