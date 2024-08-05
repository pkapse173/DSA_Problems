//Problem: Oranges Rotting
/*
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 *       
 * OUTPUT: 4
 * 
 */

/*
 * Approach - BFS using Queue
 * Time Complexity  - O(m * n):m is the number of rows and n is the number of columns 
 * Space Complexity - O(m * n)
 */


package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        
        if(grid == null || grid.length == 0) return 0;
        
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int time = 0;
        if(count == 0) return time;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];

                    if(nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 1){
                        q.add(new int[]{nr,nc});
                        grid[nr][nc] = 2;
                        count--;
                        if(count == 0) return time + 1;
                    }
                }
            }
            time++;
        }
        if(count == 0) return time - 1;
        return -1;
    }
}
