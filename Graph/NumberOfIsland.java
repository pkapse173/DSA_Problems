//Problem: Number of Islands
/*
 * Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
 *       
 * OUTPUT: 1
 * 
 */

/*
 * Approach - Traversing through grid using DFS
 * Time Complexity  - O(m * n):m is the number of rows and n is the number of columns 
 * Space Complexity - O(m * n): due to recursive calls
 */

package Graph;

public class NumberOfIsland {
        public int numIslands(char[][] grid) {
    
            if(grid == null || grid.length == 0) return 0;
    
            int count = 0;
            int row = grid.length;
            int col = grid[0].length;
    
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(grid[i][j] == '1'){
                        dfs(grid, i, j);
                        count++;
                    }
                }
            }
            return count;
        }
    
        public void dfs(char[][] grid, int i, int j){
            int row = grid.length;
            int col = grid[0].length;
            if(i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0') return;
            grid[i][j] = '0';
            dfs(grid, i+1, j);
            dfs(grid, i-1, j);
            dfs(grid, i, j+1);
            dfs(grid, i, j-1);
        } 
    }
