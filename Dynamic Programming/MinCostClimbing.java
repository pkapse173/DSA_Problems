package Dynamic Programming;

//Problem: Min Cost Climbing Stairs
/*
 * INPUT: cost = [10, 15, 20]
 *       
 * OUTPUT: 15
 * Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
 */

/*
 * Approach 1 - Dynamic programming by maintaining DP array
 * Time Complexity - O(n) 
 * Space Complexity - O(n) 
 */

public class MinCostClimbing {

        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
    
            if(n == 0) return 0;
            if(n == 1) return cost[0];
    
            int [] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 0;
    
            for(int i = 2; i <= n; i++){
                dp[i] = Math.min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1]);
            }
            return dp[n];
        }
    }

/*
 * Approach 2 - Dynamic programming by maintaining last two computational value
 * Time Complexity - O(n) 
 * Space Complexity - O(1) 
 */
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
    
            int first = cost[0];
            int second = cost[1];
    
            if(n <= 2) return Math.min(first, second);
    
            for(int i = 2; i < n; i++){
                int curr = cost[i] + Math.min(first, second);
                first = second;
                second = curr;
            }
            return Math.min(first, second); 
        }
    }
    
