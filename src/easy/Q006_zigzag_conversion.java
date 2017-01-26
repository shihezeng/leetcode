package easy;

//https://leetcode.com/problems/zigzag-conversion/
public class Q006_zigzag_conversion {
    public static String convertM(String s, int numRows) {
        if (numRows == 1)
            return s;
        char[] chars = s.toCharArray();
        int len = chars.length;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int k = 0; k < sbs.length; k++) {
            sbs[k] = new StringBuilder();
        }
        int i = 0;
        while (i < len) {
            for (int row = 0; row < numRows && i < len; row++) {
                sbs[row].append(chars[i++]);
            }
            for (int row = numRows - 2; row > 0 && i < len; row--) {
                sbs[row].append(chars[i++]);
            }
        }
        for (int j = 1; j < sbs.length; j++) {
            sbs[0].append(sbs[j]);
        }
        return sbs[0].toString();
    }

    public static String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || s.length() <= numRows
                || numRows == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        int cycle = (numRows * 2 - 2);
        int dist = cycle;
        for (int row = 0; row < numRows; row++) {
            fill(sb, row, dist, cycle, s);
            dist -= 2;
        }
        return sb.toString();
    }

    private static void fill(StringBuilder sb, int startIndex, int dist,
            int cycle, String s) {
        while (startIndex < s.length()) {
            sb.append(s.charAt(startIndex));
            startIndex += dist;
            dist = cycle - dist;
            if (dist == 0)
                dist = cycle;
        }
    }
    
    public static String convertC(String s, int numRows) {
        if (numRows == 1 || s.length()==0 || s.length()<=numRows || s==null) return s;
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length];
        int cycle=2*numRows-2;
        int idx=0;
        for(int i=0;i<numRows;i++){
            for(int j=i;j<s.length();j+=cycle){
                result[idx++]=chars[j];
                int j2=j+(cycle-i*2);
                if(j2<s.length() && (j2-j)%cycle!=0){
                    result[idx++]=chars[j2];
                }
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(convertC("PAYPALISHIRING", 4));
    }
}
