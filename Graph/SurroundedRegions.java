//Problem: Word Ladder
/*
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 *       
 * OUTPUT: 5
 * 
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", 
 * which is 5 words long.
 */

/*
 * Approach - BFS appraoch with Set
 * Time Complexity  - O(N * L) N is number of words in wordList and L is length of each word
 * Space Complexity - O(L * E) N is number pf words in wordList and L is length of each word
 */
package Graph;

public class SurroundedRegions {
        public void solve(char[][] board) {
    
            if (board == null || board.length == 0 || board[0].length == 0) {
                return;
            }
    
            int rows = board.length;
            int columns = board[0].length;
    
            //For top and bottom corner of the board
            for(int i = 0; i < columns; i++){
                if(board[0][i] == 'O'){
                    dfs(board, 0, i);
                }
                if(board[rows-1][i] == 'O'){
                    dfs(board, rows-1, i);
                }
            }  
    
            //For left and right corner of the board
            for(int j = 0; j < rows; j++){
                if(board[j][0] == 'O'){
                    dfs(board,j ,0);
                }
                if(board[j][columns-1] == 'O'){
                    dfs(board,j, columns-1);
                }
            }    
    
            //Iterating through board to change all valid places
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    if(board[i][j] == 'O')
                        board[i][j] = 'X';
            }
        }
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    if(board[i][j] == '1')
                        board[i][j] = 'O';
            }
        }
             
    }
        private void dfs(char[][] board, int i, int j){
            int rows = board.length;
            int columns = board[0].length;
    
            if(i < 0 || i >= rows || j < 0 || j >= columns || board[i][j] != 'O') return;
    
            board[i][j] = '1';
    
            dfs(board, i-1, j);
            dfs(board, i+1, j);
            dfs(board, i, j-1);
            dfs(board, i, j+1);
        }
    }