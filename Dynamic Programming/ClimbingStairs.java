package Dynamic Programming;

//Problem: Climbing Stairs
/*
 * INPUT: n = 2
 *       
 * OUTPUT: 2
 * Explanation: There are two ways to climb to the top. 1 step + 1 step, 2 steps
 */

/*
 * Approach 1 - Tabulation
 * Time Complexity - O(n) 
 * Space Complexity - O(n) 
 */

public class ClimbingStairs {
        public int climbStairs(int n) {
            
            if(n == 1) return 1;
    
            int [] dp = new int [n + 1];
            dp[1] = 1;
            dp[2] = 2;
    
            for(int i = 3; i <= n; i++){
                dp[i] = dp[i-1] + dp[i-2];
            }
    
            return dp[n];
        }
}

/*
 * Approach 2 - Space optimization
 * Time Complexity - O(n) 
 * Space Complexity - O(1) - Constant space
 */


class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }
}