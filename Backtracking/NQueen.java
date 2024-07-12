//Problem: N Queen
/*
 * INPUT: n = 4
 *       
 * OUTPUT: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 */

/*
 * Approach - Backtrack(Recursion)
 * Time Complexity: O(n! . n)
 * Space Complexiyu: O(n2)
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    List<List<String>> result;
    boolean [][] grid;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.grid = new boolean[n][n];
        backtrack(0, n);
        return result;
    }

        private void backtrack(int row, int n) {
        if (row == n) {
            List<String> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(grid[i][j] ? 'Q' : '.');
                }
                board.add(sb.toString());
            }
            result.add(board);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, n)) {
                grid[row][col] = true;
                backtrack(row + 1, n);
                grid[row][col] = false;
            }
        }
    }
        private boolean isSafe(int row, int col, int n) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (grid[i][col]) {
                return false;
            }
        }

        // Check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (grid[i][j]) {
                return false;
            }
        }

        // Check upper right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (grid[i][j]) {
                return false;
            }
        }

        return true;
    }
}
