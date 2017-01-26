package easy;

public class Q168_excel_sheet_column_title {
    public static String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n--;
            result.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(52));
        System.out.println(convertToTitle(650));
        System.out.println(convertToTitle(676));
    }
}
