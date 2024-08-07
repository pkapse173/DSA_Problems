//Problem: Course Schedule
/*
 * Input: board = numCourses = 2, prerequisites = [[1,0]]
 *       
 * OUTPUT: true
 * 
 * Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
 */

/*
 * Approach - DFS appraoch
 * Time Complexity  - O(V + E) V is the number courses and E is the number of prerequisites
 * Space Complexity - O(V + E) V is the number courses and E is the number of prerequisites
 */
package Graph;

import java.util.ArrayList;
import java.util.List;

public class courseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites){
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            graph.get(prereq).add(course);
        }

        int[] visitState = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(visitState[i] == 0){
                if(isCyclic(graph, visitState, i)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCyclic(List<List<Integer>> graph, int[] visitState, int course){
        if(visitState[course] == 1) return true;

        if(visitState[course] == 2) return false;

        visitState[course] = 1;

        for(int neighbor : graph.get(course)){
            if(isCyclic(graph, visitState, neighbor)) return true;
        }

        visitState[course] = 2;

        return false;
    }
}
