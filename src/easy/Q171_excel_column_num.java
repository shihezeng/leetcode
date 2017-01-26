package easy;

//https://leetcode.com/problems/excel-sheet-column-number/
public class Q171_excel_column_num {
	public static int titleToNumber(String s) {
        int length = s.length();
        int col=0;
        for(int i=0; i<length; i++){
            col = 26* col+ (s.charAt(i) - 'A'+1);
        }
        return col;
    }
	
	public static void main(String[] args){
		System.out.println(titleToNumber("A"));
		System.out.println(titleToNumber("ZZ"));
		System.out.println(titleToNumber("AAA"));

	}
}
