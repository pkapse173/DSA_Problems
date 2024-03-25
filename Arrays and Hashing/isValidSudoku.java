//Problem: Valid Sudoku
/*
 * Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
 *       
 * OUTPUT: true
 */
/*
 * Approach - Using HashSet validating unique numbers for sudoku
 * Time Complexity - O(1) 
 * Space Complexity - O(1)
*/

import java.util.HashSet;
import java.util.Set;

public class isValidSudoku {
    
    public boolean ValidSudoku(char[][] board) {
        
        //Using set for checking unique elements
        Set<String> set = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char num = board[i][j];
                if(num != '.'){
                    //checkking with row, col and box for numbers
                    if(!set.add(num + "row" + i) || 
                       !set.add(num + "col" + j) ||
                       !set.add(num + "box" + i/3 + "-" + j/3))
                       return false;
                }
            }
        }
        return true;
    }
        
}
