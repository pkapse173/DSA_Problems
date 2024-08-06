//Problem: Pacific Atlantic Water Flow
/*
 * Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 *       
 * OUTPUT: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
[0,4]: [0,4] -> Pacific Ocean 
       [0,4] -> Atlantic Ocean
[1,3]: [1,3] -> [0,3] -> Pacific Ocean 
       [1,3] -> [1,4] -> Atlantic Ocean
[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean 
       [1,4] -> Atlantic Ocean
[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean 
       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
[3,0]: [3,0] -> Pacific Ocean 
       [3,0] -> [4,0] -> Atlantic Ocean
[3,1]: [3,1] -> [3,0] -> Pacific Ocean 
       [3,1] -> [4,1] -> Atlantic Ocean
[4,0]: [4,0] -> Pacific Ocean 
       [4,0] -> Atlantic Ocean
Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.
 * 
 */

/*
 * Approach - DFS from borders
 * Time Complexity  - O(m * n):m is the number of rows and n is the number of columns 
 * Space Complexity - O(m * n)
 */
package Graph;

import java.util.ArrayList;
import java.util.List;

public class pacificAtlantic {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int r = heights.length;
        if(r==0) return ans;
        int c = heights[0].length;

        boolean[][] pac = new boolean[r][c];
        boolean[][] atl = new boolean[r][c];

        for(int i = 0; i < c; i++){
            dfs(0, i, pac, heights, -1);
            dfs(r-1, i, atl, heights, -1);
        }

        for(int i = 0; i < r; i++){
            dfs(i, 0, pac, heights, -1);
            dfs(i, c-1, atl, heights, -1);
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(pac[i][j] == true && atl[i][j] == true){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    
    void dfs(int i, int j, boolean[][] istrue, int[][]heights, int prevHeight){
        if(i<0 || i>=heights.length || j<0 || j>=heights[0].length || istrue[i][j] == true || heights[i][j] <prevHeight)
        return;
        istrue[i][j] = true;

        dfs(i+1, j, istrue, heights, heights[i][j]);
        dfs(i-1, j, istrue, heights, heights[i][j]);
        dfs(i, j+1, istrue, heights, heights[i][j]);
        dfs(i, j-1, istrue, heights, heights[i][j]);
    }
}

