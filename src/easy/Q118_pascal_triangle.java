package easy;

import java.util.ArrayList;
import java.util.List;

public class Q118_pascal_triangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(pascal.get(i - 1).get(j - 1)
                            + pascal.get(i - 1).get(j));
                }
            }
            pascal.add(row);
        }
        return pascal;
    }

    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> pascal = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < i; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            pascal.add(new ArrayList<Integer>(row));
        }
        return pascal;
    }

    public static void main(String[] args) {
        System.out.println(generate2(3));
    }

}
