package easy;

import java.util.Arrays;
import java.util.HashSet;

//https://leetcode.com/problems/valid-sudoku/
//https://discuss.leetcode.com/topic/27436/short-simple-java-using-strings
public class Q036_valid_sudoku {

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<Character>();
            HashSet<Character> col = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !col.add(board[j][i])) {
                    return false;
                }
                if (board[3 * (i % 3) + j / 3][3 * (i / 3) + j % 3] != '.'
                        && !cube.add(board[3 * (i % 3) + j / 3][3 * (i / 3)
                                + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidSudokuBit(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] cube = new int[9];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    idx = 1 << (board[i][j] - '0');
                    if ((row[i] & idx) > 0 || (col[j] & idx) > 0
                            || (cube[(i / 3) * 3 + j / 3] & idx) > 0) {
                        return false;
                    }
                    row[i] |= idx;
                    col[j] |= idx;
                    cube[(i / 3) * 3 + j / 3] |= idx;
                }
            }
        }
        return true;
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static void main(String[] args) {
        String[] str = { ".87654321", "2........", "3........", "4........",
                "5........", "6........", "7........", "8........",
                "9........" };
        char[][] board = new char[9][9];
        for (int i = 0; i < str.length; i++) {
            board[i] = str[i].toCharArray();
        }
        printBoard(board);
        System.out.println(isValidSudokuBit(board));
    }
}
