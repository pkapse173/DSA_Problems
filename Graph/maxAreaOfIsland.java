//Problem: Max Area of Island
/*
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 *       
 * OUTPUT: 6
 * 
 */

/*
 * Approach - Traversing through grid using DFS
 * Time Complexity  - O(m * n): m is the number of rows and n is the number of columns 
 * Space Complexity - O(m * n): due to recursive calls
 */

package Graph;

public class maxAreaOfIsland {
        public int maxAreaOfIsland(int[][] grid) {
    
            if(grid == null || grid.length == 0) return 0;
    
            int row = grid.length;
            int col = grid[0].length;
    
            int maxCount = 0;
            
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(grid[i][j] == 1){
                        int count = dfs(grid, i, j);
                        maxCount = Math.max(maxCount, count);
                    }
                }
            }
        return maxCount;
        }
        public int dfs(int[][] grid, int i, int j){
            int row = grid.length;
            int col = grid[0].length;
    
            if(i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 0){
                return 0;
            }
            grid[i][j] = 0;
            int count = 1;
    
            count += dfs(grid, i+1 ,j); 
            count += dfs(grid, i-1 ,j); 
            count += dfs(grid, i ,j+1); 
            count += dfs(grid, i ,j-1);
    
            return count;
        }
    }
