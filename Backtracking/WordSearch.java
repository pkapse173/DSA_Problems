//Problem: Word Search
/*
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 *       
 * OUTPUT: true
 */

/*
 * Approach - Backtrack(Recursion)
 * Time Complexity - O(N * 3 raise to L) - N is total number of cells in board and L is length of word we are searching for  
 * Space Complexity - O(L) - Length of word
 */
package Backtracking;

public class WordSearch {
        public boolean exist(char[][] board, String word) {
            
            if(board == null || board.length == 0 || board[0].length == 0) return false;
    
            int row = board.length;
            int col = board[0].length;
            boolean visited[][] = new boolean[row][col];
    
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(solve(board, word, i, j, 0, visited)){
                        return true;
                    }
                }
            }
            return false;
        }
    
        private boolean solve(char[][] board, String word, int i, int j, int index, boolean [][] visited){
            if(index == word.length()) return true;
    
            if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)){
                return false;
            }
    
            visited[i][j] = true;
    
            boolean found = solve(board, word, i - 1, j, index + 1, visited) || //Up
                            solve(board, word, i + 1, j, index + 1, visited) || //Down
                            solve(board, word, i, j - 1, index + 1, visited) || //Left
                            solve(board, word, i, j + 1, index + 1, visited); //Right
    
            visited [i][j] = false;
    
            return found;
        }
    }
