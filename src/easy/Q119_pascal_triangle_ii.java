package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle-ii/
public class Q119_pascal_triangle_ii {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            row.add(1);
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }

    public static List<Integer> getRow2(int rowIndex) {
        Integer[] row = new Integer[rowIndex + 1];
        Arrays.fill(row, 1);
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--) {
                row[j] += row[j - 1];
            }
        }
        return Arrays.asList(row);
    }

    public static List<Integer> getRow3(int rowIndex) {
        if (rowIndex < 0)
            return null;
        List<Integer> row = new ArrayList<Integer>(rowIndex + 1);
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println(getRow(50000));
        long t2 = System.currentTimeMillis();
        System.out.println(getRow3(50000));
        long t3 = System.currentTimeMillis();
        System.out.println("Time1=" + (t2 - t1) + "," + "Time2=" + (t3 - t2));
    }
}
