//Problem: Course Schedule II
/*
 * Input: board = numCourses = 2, prerequisites = [[1,0]]
 *       
 * OUTPUT: [0,1]
 * 
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So the correct course order is [0,1].
 */

/*
 * Approach - DFS appraoch with using Stack
 * Time Complexity  - O(V + E) V is the number courses and E is the number of prerequisites
 * Space Complexity - O(V + E) V is the number courses and E is the number of prerequisites
 */
package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class courseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites){
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        int[] visited = new int [numCourses];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                if(!dfs(i, graph, visited, stack)){
                    return new int[0];
                }
            }
        }

        int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            result[i] = stack.pop();
        }
        return result;
    }

    private boolean dfs(int node, List<List<Integer>> graph, int[] visited, Stack<Integer> stack){
        if(visited[node] == 1) return false;

        if(visited[node] == 2) return true;

        visited[node] = 1;

        for(int neighor : graph.get(node)){
            if(!dfs(neighor, graph, visited, stack)){
                return false;
            }
        }

        visited[node] = 2;
        stack.push(node);
        return true;
    }
}
